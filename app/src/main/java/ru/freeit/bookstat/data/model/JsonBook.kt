package ru.freeit.bookstat.data.model

import org.json.JSONObject

interface JsonBook {
    fun put(key: String, value: String)
    fun put(key: String, value: Int)
    fun put(key: String, value: Long)
    fun apply() : String

    fun str(key: String) : String
    fun int(key: String) : Int
    fun long(key: String) : Long

    class Base(private val jsonObject : JSONObject = JSONObject()) : JsonBook {

        override fun put(key: String, value: String) { jsonObject.put(key, value) }
        override fun put(key: String, value: Int) { jsonObject.put(key, value) }
        override fun put(key: String, value: Long) { jsonObject.put(key, value) }
        override fun apply() = jsonObject.toString()

        override fun str(key: String) : String = jsonObject.getString(key) ?: ""
        override fun int(key: String) : Int = jsonObject.getInt(key)
        override fun long(key: String): Long = jsonObject.getLong(key)

    }
}