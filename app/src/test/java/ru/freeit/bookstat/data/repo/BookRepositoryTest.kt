package ru.freeit.bookstat.data.repo

import org.junit.Assert.*
import org.junit.Test
import ru.freeit.bookstat.data.model.*
import java.util.concurrent.Executors

class BookRepositoryTest {

    @Test
    fun test_save_books() {
        val internalStorage = InternalStorageTest()
        val repo = BookRepository.Base(
            Executors.newSingleThreadExecutor(),
            internalStorage,
            JsonBooksTest(),
            JsonBookTest()
        )
        val books = Books(listOf(
            Book("Book1", 111, 1000L),
            Book("Book2", 222, 2000L)
        ))
        repo.save(books) {
            assertEquals("{Book1, 111, 1000}-{Book2, 222, 2000}", internalStorage.read(""))
        }
    }

    @Test
    fun test_save_a_book() {
        val internalStorage = InternalStorageTest()
        val repo = BookRepository.Base(
            Executors.newSingleThreadExecutor(),
            internalStorage,
            JsonBooksTest(),
            JsonBookTest()
        )
        val books = Books(listOf(Book("Book1", 111, 1000L),))
        repo.save(books) {
            repo.save(Book("Book2", 222, 2000L)) {
                assertEquals("{Book1, 111, 1000}-{Book2, 222, 2000}", internalStorage.read(""))
            }
        }
    }

    @Test
    fun test_clear_books() {
        val internalStorage = InternalStorageTest()
        val repo = BookRepository.Base(
            Executors.newSingleThreadExecutor(),
            internalStorage,
            JsonBooksTest(),
            JsonBookTest()
        )
        val books = Books(listOf(
            Book("Book1", 111, 1000L),
            Book("Book2", 222, 2000L)
        ))
        repo.save(books) {
            assertEquals("{Book1, 111, 1000}-{Book2, 222, 2000}", internalStorage.read(""))

            repo.save(Books(listOf())) {
                assertEquals("", internalStorage.read(""))
            }
        }
    }

    @Test
    fun test_remove_a_book() {
        val internalStorage = InternalStorageTest()
        val repo = BookRepository.Base(
            Executors.newSingleThreadExecutor(),
            internalStorage,
            JsonBooksTest(),
            JsonBookTest()
        )
        val mutableBooks = mutableListOf(
            Book("Book1", 111, 1000L),
            Book("Book2", 222, 2000L)
        )
        val books = Books(mutableBooks)
        repo.save(books) {
            assertEquals("{Book1, 111, 1000}-{Book2, 222, 2000}", internalStorage.read(""))

            mutableBooks.removeLast()
            repo.save(Books(mutableBooks)) {
                assertEquals("{Book1, 111, 1000}", internalStorage.read(""))
            }
        }
    }

}