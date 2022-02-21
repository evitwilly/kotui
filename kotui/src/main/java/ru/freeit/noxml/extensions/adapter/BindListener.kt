package ru.freeit.noxml.extensions.adapter

fun interface BindListener<T> {
    fun onBind(pos: Int, item: T)
}