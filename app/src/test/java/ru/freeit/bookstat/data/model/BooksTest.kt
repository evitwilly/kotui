package ru.freeit.bookstat.data.model

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class BooksTest {

    @Test
    fun test_subtract_book() {
        val book1 = Book("Book1", 111, 1000L)
        val book2 = Book("Book2", 222, 2000L)

        val books = Books(listOf(book1, book2))
        val booksAfterSubtracting = books.withoutBook(book1)

        assertEquals(listOf(book2), booksAfterSubtracting.items())
    }

    @Test
    fun test_add_book() {
        val book1 = Book("Book1", 111, 1000L)
        val book2 = Book("Book2", 222, 2000L)

        val books = Books(listOf(book1))
        val booksAfterSubtracting = books.withBook(book2)

        assertEquals(listOf(book1, book2), booksAfterSubtracting.items())
    }

    @Test
    fun test_to_json() {
        val books = Books(listOf(
            Book("Book1", 111, 1000L),
            Book("Book2", 222, 2000L)
        ))
        val json = books.toJson(JsonBooksTest(), JsonBookTest())
        assertEquals("{Book1, 111, 1000}-{Book2, 222, 2000}", json)
    }

    @Test
    fun test_from_json() {
        val books = Books.fromJson("{Book1, 111, 1000}-{Book2, 222, 2000}", JsonBooksTest())
        val expected = listOf(
            Book("Book1", 111, 1000L),
            Book("Book2", 222, 2000L)
        )
        assertEquals(expected, books.items())
    }

    @Test
    fun book_count_by_year() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, 2020)
        val millis = calendar.timeInMillis

        val books = Books(listOf(
            Book("Book1", 111, millis),
            Book("Book2", 222, millis)
        ))

        assertEquals(2, books.bookCountByYear()[2020])
    }
}