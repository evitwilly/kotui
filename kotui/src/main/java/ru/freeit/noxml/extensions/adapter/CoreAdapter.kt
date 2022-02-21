package ru.freeit.noxml.extensions.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CoreAdapter<T>(
    private val items: List<T>,
    private val viewHolderContainer: ViewHolderContainer<T>
) : RecyclerView.Adapter<CoreViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolderContainer.holder(parent)
    override fun onBindViewHolder(holder: CoreViewHolder<T>, position: Int) = holder.bind(position, items[position])
    override fun getItemCount() = items.size
}