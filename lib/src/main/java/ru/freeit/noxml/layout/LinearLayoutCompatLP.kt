package ru.freeit.noxml.layout

import android.view.Gravity
import androidx.appcompat.widget.LinearLayoutCompat

class LinearLayoutCompatLP(private var params: LinearLayoutCompat.LayoutParams = LinearLayoutCompat.LayoutParams(
    LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
    LinearLayoutCompat.LayoutParams.WRAP_CONTENT)) {

    fun width(dp: Int) = LinearLayoutCompatLP(params.apply {
        width = dp
    })

    fun centerHorizontally() = LinearLayoutCompatLP(params.apply {
        gravity = Gravity.CENTER_HORIZONTAL
    })

    fun height(dp: Int) = LinearLayoutCompatLP(params.apply {
        height = dp
    })

    fun matchWidth() = LinearLayoutCompatLP(params.apply {
        width = LinearLayoutCompat.LayoutParams.MATCH_PARENT
    })

    fun wrapWidth() = LinearLayoutCompatLP(params.apply {
        width = LinearLayoutCompat.LayoutParams.WRAP_CONTENT
    })

    fun matchHeight() = LinearLayoutCompatLP(params.apply {
        height = LinearLayoutCompat.LayoutParams.MATCH_PARENT
    })

    fun wrapHeight() = LinearLayoutCompatLP(params.apply {
        height = LinearLayoutCompat.LayoutParams.WRAP_CONTENT
    })

    fun weight(w: Float) = LinearLayoutCompatLP(params.apply {
        weight = w
    })

    fun marginStart(dp: Int) = LinearLayoutCompatLP(params.apply {
        marginStart = dp
    })

    fun marginTop(dp: Int) = LinearLayoutCompatLP(params.apply {
        topMargin = dp
    })

    fun marginBottom(dp: Int) = LinearLayoutCompatLP(params.apply {
        bottomMargin = dp
    })

    fun marginEnd(dp: Int) = LinearLayoutCompatLP(params.apply {
        marginEnd = dp
    })

    fun margins(dp: Int) = LinearLayoutCompatLP(params.apply {
        marginStart = dp
        marginEnd = dp
        topMargin = dp
        bottomMargin = dp
    })

    fun margins(startDp: Int, topDp: Int, endDp: Int, bottomDp: Int) = LinearLayoutCompatLP(params.apply {
        marginStart = startDp
        marginEnd = endDp
        topMargin = topDp
        bottomMargin = bottomDp
    })

    fun build() = params

}