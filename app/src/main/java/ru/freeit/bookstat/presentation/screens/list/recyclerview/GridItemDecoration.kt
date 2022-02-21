package ru.freeit.bookstat.presentation.screens.list.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.noxml.extensions.dp

class GridItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val eightDp = 8.dp(parent.context)
        val fourDp = eightDp / 2

        outRect.left = fourDp
        outRect.right = fourDp
        outRect.bottom = eightDp

    }
}