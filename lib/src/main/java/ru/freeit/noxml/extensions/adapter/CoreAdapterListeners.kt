package ru.freeit.noxml.extensions.adapter

interface CoreAdapterListeners {
    fun itemInserted(index: Int)
    fun itemRemoved(index: Int)
    fun itemChanged(index: Int)
}