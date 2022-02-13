package ru.freeit.noxml.extensions.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup

abstract class ViewHolderWrapper<T> {

    abstract fun view(ctx: Context) : View

    private var listener: ItemBindListener<T>? = null

    fun listenItem(listener: ItemBindListener<T>) {
        this.listener = listener
    }

    fun holder(parent: ViewGroup) : CoreViewHolder<T> {
        val view = view(parent.context)
        return CoreViewHolder(view, listener ?: ItemBindListener { _, _, _ -> })
    }


}