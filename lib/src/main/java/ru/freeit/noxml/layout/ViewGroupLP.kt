package ru.freeit.noxml.layout


import android.view.ViewGroup

class ViewGroupLP(private val params: ViewGroup.MarginLayoutParams = ViewGroup.MarginLayoutParams(
    ViewGroup.MarginLayoutParams.WRAP_CONTENT,
    ViewGroup.MarginLayoutParams.WRAP_CONTENT)) {

    fun matchWidth() = ViewGroupLP(params.apply {
        width = ViewGroup.MarginLayoutParams.MATCH_PARENT
    })

    fun wrapWidth() = ViewGroupLP(params.apply {
        width = ViewGroup.MarginLayoutParams.WRAP_CONTENT
    })

    fun matchHeight() = ViewGroupLP(params.apply {
        height = ViewGroup.MarginLayoutParams.MATCH_PARENT
    })

    fun wrapHeight() = ViewGroupLP(params.apply {
        height = ViewGroup.MarginLayoutParams.WRAP_CONTENT
    })

    fun wrap() = ViewGroupLP(params.apply {
        width = ViewGroup.MarginLayoutParams.WRAP_CONTENT
        height = ViewGroup.MarginLayoutParams.WRAP_CONTENT
    })

    fun match() = ViewGroupLP(params.apply {
        width = ViewGroup.MarginLayoutParams.MATCH_PARENT
        height = ViewGroup.MarginLayoutParams.MATCH_PARENT
    })

    fun marginStart(dp: Int) = ViewGroupLP(params.apply {
        marginStart = dp
    })

    fun marginEnd(dp: Int) = ViewGroupLP(params.apply {
        marginEnd = dp
    })

    fun marginTop(dp: Int) = ViewGroupLP(params.apply {
        topMargin = dp
    })

    fun marginBottom(dp: Int) = ViewGroupLP(params.apply {
        bottomMargin = dp
    })

    fun margins(dp: Int) = ViewGroupLP(params.apply {
        topMargin = dp
        bottomMargin = dp
        marginStart = dp
        marginEnd = dp
    })

    fun width(dp: Int) = ViewGroupLP(params.apply {
        width = dp
    })

    fun height(dp: Int) = ViewGroupLP(params.apply {
        height = dp
    })

    fun build() = params
}