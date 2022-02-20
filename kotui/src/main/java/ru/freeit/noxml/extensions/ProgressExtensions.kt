package ru.freeit.noxml.extensions


import android.app.Activity
import android.content.Context
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import com.google.android.material.progressindicator.CircularProgressIndicator

fun Activity.progressIndicator(init: CircularProgressIndicator.() -> Unit) : CircularProgressIndicator {
    val indicator = CircularProgressIndicator(this)
    indicator.init()
    return indicator
}

fun Fragment.progressIndicator(init: CircularProgressIndicator.() -> Unit) : CircularProgressIndicator {
    val indicator = CircularProgressIndicator(requireContext())
    indicator.init()
    return indicator
}

fun progressIndicator(context: Context, init: CircularProgressIndicator.() -> Unit) : CircularProgressIndicator {
    val indicator = CircularProgressIndicator(context)
    indicator.init()
    return indicator
}

fun CircularProgressIndicator.trackColor(@ColorRes colorRes: Int) {
    trackColor = context.colorBy(colorRes)
}

fun CircularProgressIndicator.indicatorColor(@ColorRes colorRes: Int) {
    setIndicatorColor(context.colorBy(colorRes))
}

fun CircularProgressIndicator.indeterminate() {
    isIndeterminate = true
}