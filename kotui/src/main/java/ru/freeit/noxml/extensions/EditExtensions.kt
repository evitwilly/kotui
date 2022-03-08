package ru.freeit.noxml.extensions

import android.app.Activity
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.SharedPreferencesCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import ru.freeit.noxml.R

fun EditText.str() = text.toString()

fun Fragment.edit(init: AppCompatEditText.() -> Unit) : AppCompatEditText {
    val text = AppCompatEditText(requireContext())
    text.init()
    return text
}

fun Activity.edit(init: AppCompatEditText.() -> Unit) : AppCompatEditText {
    val text = AppCompatEditText(this)
    text.init()
    return text
}

fun View.edit(init: AppCompatEditText.() -> Unit) : AppCompatEditText {
    val text = AppCompatEditText(context)
    text.init()
    return text
}

fun edit(context: Context, init: AppCompatEditText.() -> Unit) : AppCompatEditText {
    val text = AppCompatEditText(context)
    text.init()
    return text
}

fun AppCompatEditText.error(@StringRes res: Int) {
    error = context.resources.getString(res)
}

fun AppCompatEditText.multiline(lines: Int, grav: Int = Gravity.TOP) {
    maxLines = lines
    setLines(lines)
    gravity = grav
    inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE or InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
}

fun AppCompatEditText.bgNone() {
    background = null
}