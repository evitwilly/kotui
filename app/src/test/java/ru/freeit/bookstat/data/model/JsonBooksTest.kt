package ru.freeit.bookstat.data.model

class JsonBooksTest : JsonBooks {

    override fun json(books: List<Book>, jsonBook: JsonBook): String {
        return books.joinToString("-") { book -> book.toJson(jsonBook) }
    }

    override fun books(str: String): List<Book> {
        return str.split("-").map { bookStr ->
            val elements = bookStr.removePrefix("{").removeSuffix("}").split(",")
            print(elements)
            Book.fromJson(JsonBookTest(elements[0].trim(), elements[1].trim().toInt(), elements[2].trim().toLong()))
        }
    }

}