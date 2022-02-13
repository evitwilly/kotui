package ru.freeit.bookstat.data.model

import android.view.View
import android.widget.TextView
import ru.freeit.noxml.extensions.bg
import ru.freeit.noxml.extensions.roundedDrawable
import ru.freeit.noxml.extensions.text
import java.util.*

data class Book(
    private val name: String,
    private val selectedColor: Int,
    private val addedDate: Long = System.currentTimeMillis()) {

    fun roundedDrawableWithSelectedColor(view: View, radius: Float) {
        view.bg(roundedDrawable(selectedColor, radius))
    }

    fun bookName(textView: TextView) {
        textView.text(name)
    }

    fun addedYear(calendar: Calendar) : Int {
        calendar.timeInMillis = addedDate
        return calendar.get(Calendar.YEAR)
    }

    fun addedDate(textView: TextView, calendar: Calendar) {
        calendar.timeInMillis = addedDate
        val day = calendar.get(Calendar.DAY_OF_MONTH).toString().padStart(2, '0')
        val month = calendar.get(Calendar.MONTH).toString().padStart(2, '0')
        val year = calendar.get(Calendar.YEAR)
        textView.text("$day.$month.$year")
    }

    fun toJson(jsonBook: JsonBook) : String {
        jsonBook.put(bookNameKey, name)
        jsonBook.put(selectedColorKey, selectedColor)
        jsonBook.put(addedDateKey, addedDate)
        return jsonBook.apply()
    }

    companion object {
        private const val bookNameKey = "book_name"
        private const val addedDateKey = "added_date"
        private const val selectedColorKey = "selected_color"

        fun fromJson(json: JsonBook) = Book(
            json.str(bookNameKey),
            json.int(selectedColorKey),
            json.long(addedDateKey)
        )
    }
}