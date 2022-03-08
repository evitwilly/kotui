package ru.freeit.bookstat.presentation.toolbar

import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import ru.freeit.bookstat.R
import ru.freeit.bookstat.core.ApplicationFonts
import ru.freeit.noxml.extensions.*

class Toolbar(ctx: Context, appFonts: ApplicationFonts) : FrameLayout(ctx) {

    private val black = colorBy(R.color.black)

    private val buttonSize = dp(64)
    private val gapBetweenBackButtonAndTitleView = dp(8)
    private val initialTitleMargin = dp(16)

    private val backButton = ToolbarIconButton(context, buttonSize, Gravity.START, R.drawable.ic_back)
    private val endButton = ToolbarIconButton(context, buttonSize, Gravity.END)

    private val titleView = text {
        color(black)
        typeface(appFonts.medium())
        fontSize(21f)
        centerGravity()
        layoutParams(frameLayoutParams()
            .wrapWidth().wrapHeight()
            .gravity(Gravity.CENTER)
            .marginStart(initialTitleMargin)
            .marginEnd(initialTitleMargin))
    }

    fun title(str: String) { titleView.text(str) }
    fun onBack(listener: () -> Unit) { backButton.onClick = { listener.invoke() } }
    fun endButtonClick(listener: () -> Unit) { endButton.onClick = { listener.invoke() } }

    fun endButtonImg(@DrawableRes drawableRes: Int) {
        endButton.img(drawableRes)
    }

    fun showEndButton() {
        endButton.isVisible = true
        titleMargin(buttonSize + gapBetweenBackButtonAndTitleView)
    }

    fun hideEndButton() {
        endButton.isVisible = false
        titleMargin(initialTitleMargin)
    }

    fun showBackButton() {
        backButton.isVisible = true
        titleMargin(buttonSize + gapBetweenBackButtonAndTitleView)
    }

    fun hideBackButton() {
        backButton.isVisible = false
        titleMargin(initialTitleMargin)
    }

    private fun titleMargin(margin: Int) {
        titleView.marginStart(margin)
        titleView.marginEnd(margin)
    }

    init {
        backButton.iconRipple(R.color.purple_200, dp(48))
        backButton.isVisible = false
        endButton.iconRipple(R.color.purple_200, dp(buttonSize / 2))
        endButton.isVisible = false

        layoutParams(viewGroupLayoutParams()
            .matchWidth()
            .height(dp(64)))

        addView(backButton, titleView, endButton)
    }
}