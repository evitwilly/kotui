package ru.freeit.bookstat.data.model

class JsonBookTest(
    private var str: String = "",
    private var int: Int = 0,
    private var long: Long = 0L
) : JsonBook {

    override fun put(key: String, value: String) { str = value }
    override fun put(key: String, value: Int) { int = value }
    override fun put(key: String, value: Long) { long = value }

    override fun apply() = "{$str, $int, $long}"

    override fun str(key: String) = str
    override fun int(key: String) = int
    override fun long(key: String) = long

}