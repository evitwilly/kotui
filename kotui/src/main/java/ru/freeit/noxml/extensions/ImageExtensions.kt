package ru.freeit.noxml.extensions


import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment


fun ImageView.centerCrop() {
    scaleType = ImageView.ScaleType.CENTER_CROP
}

fun Activity.imageView(init: AppCompatImageView.() -> Unit = {}) : AppCompatImageView {
    val img = AppCompatImageView(this)
    img.init()
    return img
}

fun View.imageView(init: AppCompatImageView.() -> Unit = {}) : AppCompatImageView {
    val img = AppCompatImageView(context)
    img.init()
    return img
}

fun Fragment.imageView(init: AppCompatImageView.() -> Unit = {}) : AppCompatImageView {
    val img = AppCompatImageView(requireContext())
    img.init()
    return img
}

fun imageView(context: Context, init: AppCompatImageView.() -> Unit = {}) : AppCompatImageView {
    val img = AppCompatImageView(context)
    img.init()
    return img
}

fun AppCompatImageView.empty() {
    setImageResource(0)
    setImageBitmap(null)
}

fun AppCompatImageView.img(bitmap: Bitmap) {
    setImageBitmap(bitmap)
}

fun AppCompatImageView.imgColor(color: Int) {
    setColorFilter(color)
}

fun AppCompatImageView.img(@DrawableRes res: Int) {
    setImageResource(res)
}
