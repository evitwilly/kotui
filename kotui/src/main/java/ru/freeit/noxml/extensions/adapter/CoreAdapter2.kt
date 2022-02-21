package ru.freeit.noxml.extensions.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CoreAdapter2<T>(
    diffUtilItemCallback: DiffUtil.ItemCallback<T>,
    private val viewHolderContainer: ViewHolderContainer<T>
) : ListAdapter<T, CoreViewHolder<T>>(diffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoreViewHolder<T> {
        return viewHolderContainer.holder(parent)
    }

    override fun onBindViewHolder(holder: CoreViewHolder<T>, position: Int) {
        holder.bind(position, getItem(position))
    }

}