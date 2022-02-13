package ru.freeit.bookstat.data.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class BookTest {

    @Test
    fun test_added_year() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, 2022)
        val millis = calendar.timeInMillis

        val book = Book("Book A", 111, millis)

        assertEquals(2022, book.addedYear(calendar))
    }

    @Test
    fun test_to_json() {
        val book = Book("Book A", 111, 1000L)
        val json = book.toJson(JsonBookTest())
        assertEquals("{Book A, 111, 1000}", json)
    }

    @Test
    fun test_from_json() {
        val json = JsonBookTest("Book A", 111, 1000L)
        val book = Book.fromJson(json)
        assertEquals(Book("Book A", 111, 1000L), book)
    }
}