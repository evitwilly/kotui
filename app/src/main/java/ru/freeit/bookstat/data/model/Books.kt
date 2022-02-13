package ru.freeit.bookstat.data.model

import java.util.*

class Books(private val books: List<Book>) {

    fun withBook(book: Book) = Books(books + book)
    fun withoutBook(book: Book) = Books(books - book)

    fun bookCountByYear() : Map<Int, Int> {
        val calendar = Calendar.getInstance()
        return books.groupBy { book -> book.addedYear(calendar) }
            .mapValues { entry -> entry.value.size }
    }

    fun items() = books

    fun toJson(jsonBooks: JsonBooks, jsonBook: JsonBook) : String = jsonBooks.json(books, jsonBook)

    companion object {
        fun fromJson(str: String, jsonBooks: JsonBooks) : Books {
            if (str.isBlank()) return Books(listOf())

            return Books(jsonBooks.books(str))
        }
    }
}