package ru.freeit.bookstat.core

import java.util.*

class FormattedDate(private val millis: Long) {

    private val Int.padded
        get() = this.toString().padStart(2, '0')

    fun milliseconds() = millis

    fun string() : String {
        val year = year()
        val month = month() + 1
        val day = day()
        return "${day.padded}.${month.padded}.$year"
    }

    fun year() : Int {
        calendar.timeInMillis = millis
        return calendar.get(Calendar.YEAR)
    }

    fun month() : Int {
        calendar.timeInMillis = millis
        return calendar.get(Calendar.MONTH)
    }

    fun day(): Int {
        calendar.timeInMillis = millis
        return calendar.get(Calendar.DAY_OF_MONTH)
    }

    companion object {
        private val calendar = Calendar.getInstance()

        fun from(year: Int = 0, month: Int = 0, day: Int = 0) : FormattedDate {
            calendar.timeInMillis = 0
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            calendar.set(Calendar.HOUR, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            return FormattedDate(calendar.timeInMillis)
        }
    }
}