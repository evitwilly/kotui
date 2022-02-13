package ru.freeit.bookstat.presentation.screens.list

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
        val currentPosition = parent.getChildLayoutPosition(view)

        val eightDp = 8.dp(parent.context)
        if (currentPosition % 2 == 0) {
            outRect.right = eightDp
        }
        outRect.bottom = eightDp
    }
}