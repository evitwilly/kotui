package ru.freeit.noxml.extensions


import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import ru.freeit.noxml.R

fun TextView.copyable() {
    setTextIsSelectable(true)
    isFocusable = true
    isClickable = true
    isEnabled = true
    isLongClickable = true
}

fun TextView.typeface(typeface: Typeface) {
    this.typeface = typeface
}

fun TextView.typeface(assets: String) {
    this.typeface = Typeface.createFromAsset(this.context.assets, "Montserrat-Bold.ttf")
}

fun TextView.fontSize(sp: Float) {
    setTextSize(TypedValue.COMPLEX_UNIT_SP, sp)
}

fun TextView.colorRes(@ColorRes colorRes: Int) {
    setTextColor(context.colorBy(colorRes))
}

fun TextView.singleLine() {
    isSingleLine = true
    maxLines = 1
}

fun TextView.color(color: Int) {
    setTextColor(color)
}

fun TextView.centerGravity() {
    gravity = Gravity.CENTER
}

fun TextView.centerHorizontalGravity() {
    gravity = Gravity.CENTER_HORIZONTAL
}

fun TextView.centerVerticalGravity() {
    gravity = Gravity.CENTER_VERTICAL
}


fun Fragment.text(init: AppCompatTextView.() -> Unit) : AppCompatTextView {
    val text = AppCompatTextView(requireContext())
    text.init()
    return text
}

fun Activity.text(init: AppCompatTextView.() -> Unit) : AppCompatTextView {
    val text = AppCompatTextView(this)
    text.init()
    return text
}

fun View.text(init: AppCompatTextView.() -> Unit) : AppCompatTextView {
    val text = AppCompatTextView(context)
    text.init()
    return text
}

fun text(context: Context, init: AppCompatTextView.() -> Unit) : AppCompatTextView {
    val text = AppCompatTextView(context)
    text.init()
    return text
}

fun AppCompatEditText.hintColor(@ColorRes colorRes: Int) {
    setHintTextColor(colorBy(colorRes))
}
fun AppCompatEditText.hint(@StringRes stringRes: Int) {
    setHint(stringRes)
}
fun AppCompatEditText.hint(str: String) {
    hint = str
}

fun TextView.stringRes(@StringRes res: Int) {
    setText(res)
}

fun AppCompatTextView.textCenter() {
    textAlignment = View.TEXT_ALIGNMENT_CENTER
}

fun AppCompatTextView.textStart() {
    textAlignment = View.TEXT_ALIGNMENT_TEXT_START
}

fun AppCompatTextView.textEnd() {
    textAlignment = View.TEXT_ALIGNMENT_TEXT_END
}

fun <T> TextView.text(data: T) {
    text = data.toString()
}

fun TextView.text(str: CharSequence) {
    text = str
}