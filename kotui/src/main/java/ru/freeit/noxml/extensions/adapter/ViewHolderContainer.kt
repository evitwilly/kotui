package ru.freeit.noxml.extensions.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup

abstract class ViewHolderContainer<T> {

    abstract fun view(ctx: Context) : View

    private var listener: BindListener<T>? = null

    fun onBind(listener: BindListener<T>) {
        this.listener = listener
    }

    fun holder(parent: ViewGroup) : CoreViewHolder<T> {
        val view = view(parent.context)
        return CoreViewHolder(view, listener ?: BindListener { _, _ -> })
    }


}