package ru.freeit.noxml.extensions.adapter

fun interface ItemBindListener<T> {
    fun onBind(pos: Int, item: T, coreAdapterListeners: CoreAdapterListeners)
}