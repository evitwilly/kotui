package ru.freeit.noxml.extensions


import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import ru.freeit.noxml.layout.*

fun linearLayoutParams() = LinearLayoutLP()
fun linearLayoutCompatParams() = LinearLayoutCompatLP()
fun frameLayoutParams() = FrameLayoutLP()
fun viewGroupLayoutParams() = ViewGroupLP()
fun recyclerLayoutParams() = RecyclerViewLP()
fun coordinatorLayoutParams() = CoordinatorLP()

fun Activity.frameLayout(builder: FrameLayout.() -> Unit = {}) : FrameLayout {
    val frame = FrameLayout(this)
    builder(frame)
    return frame
}

fun Fragment.frameLayout(builder: FrameLayout.() -> Unit = {}) : FrameLayout {
    val frame = FrameLayout(requireContext())
    builder(frame)
    return frame
}

fun View.frameLayout(builder: FrameLayout.() -> Unit = {}) : FrameLayout {
    val frame = FrameLayout(context)
    builder(frame)
    return frame
}

fun frameLayout(ctx: Context, builder: FrameLayout.() -> Unit = {}) : FrameLayout {
    val frame = FrameLayout(ctx)
    builder(frame)
    return frame
}

fun Activity.linearLayout(init: LinearLayout.() -> Unit) : LinearLayout {
    val linearLayout = LinearLayout(this)
    linearLayout.init()
    return linearLayout
}

fun Fragment.linearLayout(init: LinearLayout.() -> Unit) : LinearLayout {
    val linearLayout = LinearLayout(requireContext())
    linearLayout.init()
    return linearLayout
}

fun View.linearLayout(init: LinearLayout.() -> Unit) : LinearLayout {
    val linearLayout = LinearLayout(context)
    linearLayout.init()
    return linearLayout
}

fun linearLayout(context: Context, init: LinearLayout.() -> Unit) : LinearLayout {
    val linearLayout = LinearLayout(context)
    linearLayout.init()
    return linearLayout
}

fun Activity.linearLayoutCompat(init: LinearLayoutCompat.() -> Unit) : LinearLayoutCompat {
    val linearLayout = LinearLayoutCompat(this)
    linearLayout.init()
    return linearLayout
}

fun Fragment.linearLayoutCompat(init: LinearLayoutCompat.() -> Unit) : LinearLayoutCompat {
    val linearLayout = LinearLayoutCompat(requireContext())
    linearLayout.init()
    return linearLayout
}

fun View.linearLayoutCompat(init: LinearLayoutCompat.() -> Unit) : LinearLayoutCompat {
    val linearLayout = LinearLayoutCompat(context)
    linearLayout.init()
    return linearLayout
}

fun linearLayoutCompat(context: Context, init: LinearLayoutCompat.() -> Unit) : LinearLayoutCompat {
    val linearLayout = LinearLayoutCompat(context)
    linearLayout.init()
    return linearLayout
}

fun LinearLayout.vertical() { orientation = LinearLayout.VERTICAL }
fun LinearLayout.horizontal() { orientation = LinearLayout.HORIZONTAL }
fun LinearLayout.centerHorizontal() { gravity = Gravity.CENTER_HORIZONTAL }
fun LinearLayout.centerVertical() { gravity = Gravity.CENTER_VERTICAL }
fun LinearLayout.center() { gravity = Gravity.CENTER }

fun LinearLayoutCompat.vertical() { orientation = LinearLayoutCompat.VERTICAL }
fun LinearLayoutCompat.horizontal() { orientation = LinearLayoutCompat.HORIZONTAL }
fun LinearLayoutCompat.centerHorizontal() { gravity = Gravity.CENTER_HORIZONTAL }
fun LinearLayoutCompat.centerVertical() { gravity = Gravity.CENTER_VERTICAL }
fun LinearLayoutCompat.center() { gravity = Gravity.CENTER }

fun ViewGroup.addView(vararg view: View) {
    view.forEach { view -> addView(view) }
}
