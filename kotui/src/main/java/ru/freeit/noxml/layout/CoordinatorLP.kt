package ru.freeit.noxml.layout

import androidx.coordinatorlayout.widget.CoordinatorLayout

private const val match = CoordinatorLayout.LayoutParams.MATCH_PARENT
private const val wrap = CoordinatorLayout.LayoutParams.WRAP_CONTENT

class CoordinatorLP(private var params: CoordinatorLayout.LayoutParams = CoordinatorLayout.LayoutParams(wrap, wrap))
    : AbstractMarginLP<CoordinatorLayout.LayoutParams,CoordinatorLP>(params, match, wrap), LP<CoordinatorLayout.LayoutParams> {

    fun gravity(grav: Int) = CoordinatorLP(params.apply { gravity = grav })

    override fun build() = params
    override fun with(params: CoordinatorLayout.LayoutParams) = CoordinatorLP(params)

}