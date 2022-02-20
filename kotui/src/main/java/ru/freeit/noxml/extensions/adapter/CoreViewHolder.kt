package ru.freeit.noxml.extensions.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CoreViewHolder<T>(view: View, private val listener: ItemBindListener<T>) : RecyclerView.ViewHolder(view) {
    fun bind(position: Int, item: T, coreAdapterListeners: CoreAdapterListeners) {
        listener.onBind(position, item, coreAdapterListeners)
    }
}