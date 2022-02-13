package ru.freeit.bookstat.presentation.toolbar

import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import ru.freeit.noxml.extensions.*

class ToolbarIconButton(ctx: Context, buttonSize: Int, gravity: Int, @DrawableRes icon: Int = -1) : FrameLayout(ctx) {

    fun iconRipple(@ColorRes colorRes: Int, radius: Int) { ripple(colorRes, radius) }
    fun img(@DrawableRes drawableRes: Int) {
        imageView.img(drawableRes)
    }

    private val imageView = imageView {
        if (icon != -1) {
            img(icon)
        }

        val layoutParams = frameLayoutParams().wrapWidth().wrapHeight()
            .gravity(gravity or Gravity.CENTER_VERTICAL)

        if (gravity == Gravity.START) {
            layoutParams.marginStart(dp(16))
        } else if (gravity == Gravity.END) {
            layoutParams.marginEnd(dp(16))
        }

        layoutParams(layoutParams.build())
    }

    init {
        clickable()
        layoutParams(frameLayoutParams().width(buttonSize)
            .height(buttonSize)
            .gravity(gravity)
            .build())
        addView(imageView)
    }
}