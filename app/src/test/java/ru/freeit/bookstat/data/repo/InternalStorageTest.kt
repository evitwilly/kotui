package ru.freeit.bookstat.data.repo

import ru.freeit.bookstat.data.storage.InternalStorage

class InternalStorageTest : InternalStorage {
    private var data: String = ""

    override fun save(filename: String, data: String) {
        this.data = data
    }

    override fun read(filename: String) = data

}