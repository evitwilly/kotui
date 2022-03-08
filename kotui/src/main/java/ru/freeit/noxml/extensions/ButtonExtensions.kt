package ru.freeit.noxml.extensions

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.*
import android.os.Build
import android.util.StateSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Button
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

inline fun Activity.button(init: Button.() -> Unit) : Button {
    val button = Button(this)
    button.init()
    return button
}

inline fun Fragment.button(init: Button.() -> Unit) : Button {
    val button = Button(context)
    button.init()
    return button
}

fun button(context: Context, init: Button.() -> Unit) : Button {
    val button = Button(context)
    button.init()
    return button
}


fun Fragment.floatingButton(init: FloatingActionButton.() -> Unit) : FloatingActionButton {
    val button = FloatingActionButton(requireContext())
    button.init()
    return button
}

fun View.floatingButton(init: FloatingActionButton.() -> Unit) : FloatingActionButton {
    val button = FloatingActionButton(context)
    button.init()
    return button
}

fun FloatingActionButton.imgColor(@ColorRes colorRes: Int) {
    setColorFilter(colorBy(colorRes))
}

fun Activity.floatingButton(init: FloatingActionButton.() -> Unit) : FloatingActionButton {
    val button = FloatingActionButton(this)
    button.init()
    return button
}

fun floatingButton(context: Context, init: FloatingActionButton.() -> Unit) : FloatingActionButton {
    val button = FloatingActionButton(context)
    button.init()
    return button
}

fun FloatingActionButton.img(@DrawableRes drawableRes: Int) {
    setImageResource(drawableRes)
}

fun FloatingActionButton.size(dp: Int) {
    customSize = dp
}

fun FloatingActionButton.tint(@ColorRes colorRes: Int) {
    ViewCompat.setBackgroundTintList(this, ColorStateList.valueOf(colorBy(colorRes)))
}



fun Button.tint(@ColorRes colorRes: Int) {
    ViewCompat.setBackgroundTintList(this, ColorStateList.valueOf(context.colorBy(colorRes)))
}

fun Button.ripple(@ColorRes colorRes: Int, rippleRadius: Int = 0) {
    if (Build.VERSION.SDK_INT < 23) {
        val tintColor = ViewCompat.getBackgroundTintList(this)?.defaultColor ?: Color.TRANSPARENT
        ViewCompat.setBackgroundTintList(this, ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_pressed), StateSet.WILD_CARD),
            intArrayOf(context.colorBy(colorRes), tintColor)
        ))
    } else {
        val drawableBackground = background
        background = RippleDrawable(ColorStateList.valueOf(context.colorBy(colorRes)), drawableBackground, null).apply {
            radius = rippleRadius
        }
    }
}

fun Button.enable(yes: Boolean) {
    isEnabled = yes
}

fun Button.enable() {
    isEnabled = true
}

fun Button.disable() {
    isEnabled = false
}

fun Button.endIcon(@DrawableRes res: Int, tint: Int = Color.BLACK) {
    val drawable = AppCompatResources.getDrawable(context, res)?.apply {
        setBounds(0, 0, 14.dp(context), 8.dp(context))
        DrawableCompat.setTint(this, tint)
    }

    compoundDrawablePadding = 4.dp(context)
    setCompoundDrawables(null, null, drawable, null)
}

fun Button.backgroundColor(color: Int) {
    ViewCompat.setBackgroundTintList(this, ColorStateList.valueOf(color))
}

fun Button.textSizeInSp(size: Float) {
    setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
}


fun Button.textResId(@StringRes res: Int) {
    setText(res)
}