package ru.freeit.bookstat.core

import org.junit.Assert.*
import org.junit.Test

class FormattedDateTest {
    @Test
    fun test_millis() {
        val expected = 242847938348
        val formattedDate = FormattedDate(expected)
        val actual = formattedDate.milliseconds()
        assertEquals(expected, actual)
    }

    @Test
    fun test_string() {
        val formattedDate = FormattedDate(1642870800000)
        val actual = formattedDate.string()
        val expected = "23.01.2022"
        assertEquals(expected, actual)
    }

    @Test
    fun test_year() {
        val formattedDate = FormattedDate(1642870800000)
        val actual = formattedDate.year()
        val expected = 2022
        assertEquals(expected, actual)
    }

    @Test
    fun test_month() {
        val formattedDate = FormattedDate(1642870800000)
        val actual = formattedDate.month()
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun test_day() {
        val formattedDate = FormattedDate(1642870800000)
        val actual = formattedDate.day()
        val expected = 23
        assertEquals(expected, actual)
    }

    @Test
    fun test_from() {
        val formattedDate = FormattedDate.from(2022, 0, 23)
        val actual = formattedDate.milliseconds()
        val expected = 1642870800000
        assertEquals(expected, actual)
    }
}