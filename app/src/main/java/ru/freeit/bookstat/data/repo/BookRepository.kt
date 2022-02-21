package ru.freeit.bookstat.data.repo

import ru.freeit.bookstat.data.BookResultListener
import ru.freeit.bookstat.data.BookSavingListener
import ru.freeit.bookstat.data.model.Book
import ru.freeit.bookstat.data.model.Books
import ru.freeit.bookstat.data.model.JsonBook
import ru.freeit.bookstat.data.model.JsonBooks
import ru.freeit.bookstat.data.storage.InternalStorage
import java.util.concurrent.ExecutorService

interface BookRepository {
    fun remove(book: Book)
    fun save(book: Book, listener: BookSavingListener)
    fun read(callback: BookResultListener)

    class Base(
        private val service: ExecutorService,
        private val internalStorage: InternalStorage,
        private val jsonBooks: JsonBooks = JsonBooks.Base(),
        private val jsonBook: JsonBook = JsonBook.Base()
    ) : BookRepository {

        private var bookResultListener: BookResultListener = BookResultListener {}

        override fun remove(book: Book) {
            service.execute {
                val books = Books.fromJson(internalStorage.read(filename), jsonBooks)
                val newBooks = books.withoutBook(book)
                internalStorage.save(filename, newBooks.toJson(jsonBooks, jsonBook))
                bookResultListener.onResult(books)
            }
        }

        override fun save(book: Book, listener: BookSavingListener) {
            service.execute {
                val books = Books.fromJson(internalStorage.read(filename), jsonBooks)
                val newBooks = books.withBook(book)
                internalStorage.save(filename, newBooks.toJson(jsonBooks, jsonBook))
                listener.onSaved()
            }
        }

        override fun read(callback: BookResultListener) {
            this.bookResultListener = callback
            service.execute {
                val books = Books.fromJson(internalStorage.read(filename), jsonBooks)
                callback.onResult(books)
            }
        }

        companion object {
            private const val filename = "book_repository_data"
        }

    }
}