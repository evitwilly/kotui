package ru.freeit.noxml.layout

import android.widget.FrameLayout

class FrameLayoutLP(private val params: FrameLayout.LayoutParams = FrameLayout.LayoutParams( FrameLayout.LayoutParams.WRAP_CONTENT,
    FrameLayout.LayoutParams.WRAP_CONTENT)) {
    private val match = FrameLayout.LayoutParams.MATCH_PARENT
    private val wrap = FrameLayout.LayoutParams.WRAP_CONTENT

    fun matchWidth() = FrameLayoutLP(params.apply {
        width = match
    })

    fun width(dp: Int) = FrameLayoutLP(params.apply {
        width = dp
    })


    fun wrapWidth() = FrameLayoutLP(params.apply {
        width = wrap
    })

    fun height(dp: Int) = FrameLayoutLP(params.apply {
        height = dp
    })

    fun matchHeight() = FrameLayoutLP(params.apply {
        height = match
    })

    fun wrapHeight() = FrameLayoutLP(params.apply {
        height = wrap
    })

    fun gravity(grav: Int) = FrameLayoutLP(params.apply {
        gravity = grav
    })

    fun build() = params

    fun marginStart(dp: Int) = FrameLayoutLP(params.apply {
        marginStart = dp
    })

    fun marginEnd(dp: Int) = FrameLayoutLP(params.apply {
        marginEnd = dp
    })

    fun marginTop(dp: Int) = FrameLayoutLP(params.apply {
        topMargin = dp
    })

    fun marginBottom(dp: Int) = FrameLayoutLP(params.apply {
        bottomMargin = dp
    })

    fun margins(startDp: Int, topDp: Int, endDp: Int, bottomDp: Int) = FrameLayoutLP(params.apply {
        marginStart = startDp
        marginEnd = endDp
        topMargin = topDp
        bottomMargin = bottomDp
    })
}