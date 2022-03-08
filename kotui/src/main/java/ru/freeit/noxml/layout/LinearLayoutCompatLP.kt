package ru.freeit.noxml.layout

import androidx.appcompat.widget.LinearLayoutCompat

private const val match = LinearLayoutCompat.LayoutParams.MATCH_PARENT
private const val wrap = LinearLayoutCompat.LayoutParams.WRAP_CONTENT

class LinearLayoutCompatLP(private var params: LinearLayoutCompat.LayoutParams = LinearLayoutCompat.LayoutParams(match, wrap))
    : AbstractMarginLP<LinearLayoutCompat.LayoutParams, LinearLayoutCompatLP>(params, match, wrap), LP<LinearLayoutCompat.LayoutParams> {

    fun weight(w: Float) = LinearLayoutCompatLP(params.apply { weight = w })
    fun gravity(grav: Int) = LinearLayoutCompatLP(params.apply { gravity = grav })

    override fun with(params: LinearLayoutCompat.LayoutParams) = LinearLayoutCompatLP(params)
    override fun build() = params

}