package ru.freeit.bookstat.data.model

import org.json.JSONArray
import org.json.JSONObject

interface JsonBooks {
    fun json(books: List<Book>, jsonBook: JsonBook) : String
    fun books(str: String) : List<Book>

    class Base: JsonBooks {

        override fun json(books: List<Book>, jsonBook: JsonBook): String {
            val jsonArray = JSONArray()
            books.forEach { book ->
                jsonArray.put(JSONObject(book.toJson(jsonBook)))
            }
            return jsonArray.toString()
        }

        override fun books(str: String): List<Book> {

            val json = JSONArray(str)
            val size = json.length()

            val books = mutableListOf<Book>()

            for (index in 0 until size) {
                val jsonObject = json.getJSONObject(index)
                val jsonBook = JsonBook.Base(jsonObject)
                books.add(Book.fromJson(jsonBook))
            }

            return books
        }

    }
}