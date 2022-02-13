package ru.freeit.bookstat.data

import ru.freeit.bookstat.data.model.Books

fun interface BookSavingListener {
    fun onSaved()
}

fun interface BookResultListener {
    fun onResult(books: Books)
}