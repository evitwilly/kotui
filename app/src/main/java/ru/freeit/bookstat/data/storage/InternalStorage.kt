package ru.freeit.bookstat.data.storage

import java.io.File

interface InternalStorage {
    fun save(filename: String, data: String)
    fun read(filename: String) : String

    class Base(private val rootDirectory: File) : InternalStorage {

        override fun save(filename: String, data: String) {
            val myFile = File(rootDirectory, filename)
            myFile.bufferedWriter().use { out -> out.write(data) }
        }

        override fun read(filename: String): String {
            val myFile = File(rootDirectory, filename)
            if (!myFile.exists()) return ""
            return myFile.bufferedReader().use { out -> out.readText() }
        }

    }

}
