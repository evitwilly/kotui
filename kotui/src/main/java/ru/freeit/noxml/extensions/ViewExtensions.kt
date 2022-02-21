package ru.freeit.noxml.extensions


import android.R
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.*
import android.os.Build
import android.util.StateSet
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

fun Context.dp(dimen: Int) = (resources.displayMetrics.density * dimen).roundToInt()
fun View.dp(dimen: Int) = (resources.displayMetrics.density * dimen).roundToInt()
fun Activity.dp(dimen: Int) = (resources.displayMetrics.density * dimen).roundToInt()
fun Fragment.dp(dimen: Int) = (resources.displayMetrics.density * dimen).roundToInt()

fun Context.dp(dimen: Float) = (resources.displayMetrics.density * dimen)
fun View.dp(dimen: Float) = (resources.displayMetrics.density * dimen)
fun Activity.dp(dimen: Float) = (resources.displayMetrics.density * dimen)
fun Fragment.dp(dimen: Float) = (resources.displayMetrics.density * dimen)

fun Float.sp(ctx: Context) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, ctx.resources.displayMetrics)
fun Int.dp(ctx: Context) = (ctx.resources.displayMetrics.density * this).roundToInt()
fun Int.dpf(ctx: Context) = (ctx.resources.displayMetrics.density * this)

fun Context.colorBy(@ColorRes res: Int) = ContextCompat.getColor(this, res)
fun View.colorBy(@ColorRes res: Int) = ContextCompat.getColor(context, res)
fun Activity.colorBy(@ColorRes res: Int) = ContextCompat.getColor(this, res)
fun Fragment.colorBy(@ColorRes res: Int) = ContextCompat.getColor(requireContext(), res)

fun View.id(@IdRes idRes: Int) {
    id = idRes
}

fun View.id() : Int {
    val newId = View.generateViewId()
    id = newId
    return newId
}

fun View.ripple(@ColorRes colorRes: Int, rippleRadius: Int = 0) {
    val rippleColor = colorBy(colorRes)
    val drawableBackground = background
    if (Build.VERSION.SDK_INT < 23) {
        val pressedDrawable = if (rippleRadius > 0) GradientDrawable().apply {
            cornerRadius = dp(100f)
            setColor(rippleColor)
        } else ColorDrawable(rippleColor)
        background = StateListDrawable().apply {
            addState(intArrayOf(R.attr.state_pressed), pressedDrawable)
            addState(StateSet.WILD_CARD, drawableBackground)
        }
    } else {
        val colorStateList = ColorStateList.valueOf(rippleColor)
        background = RippleDrawable(colorStateList, drawableBackground, null).apply {
            radius = rippleRadius
        }
    }
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    isVisible = true
}

fun View.visible(isSo: Boolean) {
    isVisible = isSo
}

fun View.gone() {
    isVisible = false
}

fun View.clickable() {
    isClickable = true
}

fun View.focusable() {
    isFocusable = true
}

inline fun View.longClick(crossinline listener: () -> Unit) {
    setOnLongClickListener { listener(); true }
}

inline fun View.click(crossinline listener: () -> Unit) {
    setOnClickListener { listener() }
}

fun View.marginStart(dp: Int) = (layoutParams as? ViewGroup.MarginLayoutParams)?.run {
    marginStart = dp
}

fun View.marginEnd(dp: Int) = (layoutParams as? ViewGroup.MarginLayoutParams)?.run {
    marginEnd = dp
}

fun View.marginTop(dp: Int) = (layoutParams as? ViewGroup.MarginLayoutParams)?.run {
    topMargin = dp
}

fun View.marginBottom(dp: Int) = (layoutParams as? ViewGroup.MarginLayoutParams)?.run {
    bottomMargin = dp
}

fun View.padding(start: Int = paddingStart, top: Int = paddingTop, end: Int = paddingEnd, bottom: Int = paddingBottom) {
    setPadding(start, top, end, bottom)
}

fun View.padding(horizontal: Int, vertical: Int) {
    padding(horizontal, vertical, horizontal, vertical)
}

fun View.padding(all: Int) {
    padding(all, all, all, all)
}

fun View.afterMeasure(func: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            func()
        }
    })
}


fun Fragment.emptyView(init: View.() -> Unit) : View {
    val view = View(requireContext())
    view.init()
    return view
}

fun Activity.emptyView(init: View.() -> Unit) : View {
    val view = View(this)
    view.init()
    return view
}

fun View.emptyView(init: View.() -> Unit) : View {
    val view = View(context)
    view.init()
    return view
}

fun emptyView(ctx: Context, init: View.() -> Unit) : View {
    val view = View(ctx)
    view.init()
    return view
}

fun View.layoutParams(params: ViewGroup.LayoutParams) {
    layoutParams = params
}

fun View.bgColor(color: Int) {
    setBackgroundColor(color)
}

fun View.bgColorRes(@ColorRes color: Int) {
    setBackgroundColor(context.colorBy(color))
}

fun View.bg(@DrawableRes res: Int) {
    setBackgroundResource(res)
}

fun View.bg(res: Drawable) {
    background = res
}

fun View.snackBar(title: CharSequence, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, title, length).show()
}

fun View.snackBar(@StringRes titleResId: Int, length: Int = Snackbar.LENGTH_SHORT) {
    val snack = Snackbar.make(this, titleResId, length).show()
}

fun View.toast(@StringRes stringRes: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, stringRes, length).show()
}

fun View.toast(text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, text, length).show()
}

fun View.ripple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

fun View.bitmap() : Bitmap {
    val returnedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(returnedBitmap)
    val bgDrawable = background
    if (bgDrawable != null) bgDrawable.draw(canvas) else canvas.drawColor(Color.WHITE)
    draw(canvas)
    return returnedBitmap
}

fun roundedDrawable(color: Int, radius: Float) = GradientDrawable().apply {
        setColor(color)
        cornerRadius = radius
}