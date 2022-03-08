package ru.freeit.noxml.layout

import android.view.ViewGroup

interface LP<T : ViewGroup.LayoutParams> {
    fun build() : T
}