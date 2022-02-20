package ru.freeit.noxml.extensions.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CoreAdapter<T>(
    private val items: MutableList<T>,
    private val viewHolderWrapper: ViewHolderWrapper<T>
) : RecyclerView.Adapter<CoreViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolderWrapper.holder(parent)
    override fun onBindViewHolder(holder: CoreViewHolder<T>, position: Int) = holder.bind(position, items[position], object:
        CoreAdapterListeners {
        override fun itemInserted(index: Int) {
            notifyItemInserted(index)
        }

        override fun itemRemoved(index: Int) {
            if (index >= 0 && index < items.size) {
                items.removeAt(index)
                notifyItemRemoved(index)
                notifyItemRangeChanged(index, items.size)
            }
        }

        override fun itemChanged(index: Int) {
            notifyItemChanged(index)
        }

    })
    override fun getItemCount() = items.size
}