package ru.freeit.noxml.layout


import android.view.ViewGroup

private const val match = ViewGroup.LayoutParams.MATCH_PARENT
private const val wrap = ViewGroup.LayoutParams.WRAP_CONTENT

class ViewGroupLP(private val params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(wrap, wrap)) : LP<ViewGroup.LayoutParams> {

    private val match = ViewGroup.LayoutParams.MATCH_PARENT
    private val wrap = ViewGroup.LayoutParams.WRAP_CONTENT

    fun matchWidth() = ViewGroupLP(params.apply { width = match })
    fun matchHeight() = ViewGroupLP(params.apply { height = wrap })
    fun match() = ViewGroupLP(params.apply {
        width = match
        height = match
    })

    fun wrapWidth() = ViewGroupLP(params.apply { width = wrap })
    fun wrapHeight() = ViewGroupLP(params.apply { height = wrap })
    fun wrap() = ViewGroupLP(params.apply {
        width = wrap
        height = wrap
    })

    fun width(dp: Int) = ViewGroupLP(params.apply { width = dp })
    fun height(dp: Int) = ViewGroupLP(params.apply { height = dp })

    override fun build() = params
}