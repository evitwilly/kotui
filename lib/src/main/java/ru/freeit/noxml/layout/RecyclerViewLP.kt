package ru.freeit.noxml.layout


import androidx.recyclerview.widget.RecyclerView

class RecyclerViewLP(private val params : RecyclerView.LayoutParams = RecyclerView.LayoutParams(0, 0)) {

    fun build() = params

    fun width(dp: Int) = RecyclerViewLP(params.apply {
        width = dp
    })

    fun matchWidth() = RecyclerViewLP(params.apply {
        width = RecyclerView.LayoutParams.MATCH_PARENT
    })

    fun matchHeight() = RecyclerViewLP(params.apply {
        height = RecyclerView.LayoutParams.MATCH_PARENT
    })

    fun height(dp: Int) = RecyclerViewLP(params.apply {
        height = dp
    })

    fun marginTop(dp: Int) = RecyclerViewLP(params.apply {
        topMargin = dp
    })

    fun marginStart(dp: Int) = RecyclerViewLP(params.apply {
        marginStart = dp
    })

    fun marginEnd(dp: Int) = RecyclerViewLP(params.apply {
        marginEnd = dp
    })

    fun marginBottom(dp: Int) = RecyclerViewLP(params.apply {
        bottomMargin = dp
    })

    fun wrapHeight() = RecyclerViewLP(params.apply {
        height = RecyclerView.LayoutParams.WRAP_CONTENT
    })

}