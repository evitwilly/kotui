package ru.freeit.bookstat.data.repo

import org.junit.Assert.*
import org.junit.Test
import ru.freeit.bookstat.data.model.*
import java.util.concurrent.Executors

class BookRepositoryTest {

    @Test
    fun test_save_book() {
        val internalStorage = InternalStorageTest()
        val repo = BookRepository.Base(
            Executors.newSingleThreadExecutor(),
            internalStorage,
            JsonBooksTest(),
            JsonBookTest()
        )

        repo.save(Book("Book1", 111, 1000L)) {
            assertEquals("{Book1, 111, 1000}", internalStorage.read(""))

        }
    }

    @Test
    fun test_read_book() {
        val internalStorage = InternalStorageTest()
        val repo = BookRepository.Base(
            Executors.newSingleThreadExecutor(),
            internalStorage,
            JsonBooksTest(),
            JsonBookTest()
        )

        internalStorage.save("", "{Book1, 111, 1000}")

        repo.read { books ->
            assertEquals(Books(listOf(Book("Book1", 111, 1000L))), books)
        }
    }

    @Test
    fun test_remove_book() {
        val internalStorage = InternalStorageTest()
        val repo = BookRepository.Base(
            Executors.newSingleThreadExecutor(),
            internalStorage,
            JsonBooksTest(),
            JsonBookTest()
        )

        internalStorage.save("", "{Book1, 111, 1000}-{Book2, 222, 2000}")

        repo.remove(Book("Book1", 111, 1000L)) {
            assertEquals("{Book2, 222, 2000}", internalStorage.read(""))
        }
    }

}