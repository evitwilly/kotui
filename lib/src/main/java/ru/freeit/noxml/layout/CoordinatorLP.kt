package ru.freeit.noxml.layout

import androidx.coordinatorlayout.widget.CoordinatorLayout

class CoordinatorLP(private var params: CoordinatorLayout.LayoutParams = CoordinatorLayout.LayoutParams(
    CoordinatorLayout.LayoutParams.WRAP_CONTENT,
    CoordinatorLayout.LayoutParams.WRAP_CONTENT
)
) {

    fun matchWidth() = CoordinatorLP(params.apply {
        width = CoordinatorLayout.LayoutParams.MATCH_PARENT
    })

    fun wrapHeight() = CoordinatorLP(params.apply {
        height = CoordinatorLayout.LayoutParams.WRAP_CONTENT
    })

    fun gravity(grav: Int) = CoordinatorLP(params.apply {
        gravity = grav
    })

    fun build() = params

}