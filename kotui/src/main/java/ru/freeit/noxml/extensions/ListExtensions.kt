package ru.freeit.noxml.extensions



import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.noxml.extensions.adapter.CoreAdapter
import ru.freeit.noxml.extensions.adapter.ViewHolderWrapper


fun RecyclerView.itemDecoration(decoration: RecyclerView.ItemDecoration) {
    addItemDecoration(decoration)
}

fun RecyclerView.horizontal(reverse: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, reverse)
}

fun RecyclerView.vertical(reverse: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, reverse)
}

fun RecyclerView.grid(column: Int) {
    layoutManager = GridLayoutManager(context, column)
}

fun Activity.list(init: RecyclerView.() -> Unit) : RecyclerView {
    val list = RecyclerView(this)
    list.init()
    return list
}

fun View.list(init: RecyclerView.() -> Unit) : RecyclerView {
    val list = RecyclerView(context)
    list.init()
    return list
}

fun Fragment.list(init: RecyclerView.() -> Unit) : RecyclerView {
    val list = RecyclerView(requireContext())
    list.init()
    return list
}

fun list(ctx: Context, init: RecyclerView.() -> Unit) : RecyclerView {
    val list = RecyclerView(ctx)
    list.init()
    return list
}

fun Fragment.scrollView(init: ScrollView.() -> Unit) : ScrollView {
    val scroll = ScrollView(requireContext())
    scroll.init()
    return scroll
}

fun Activity.scrollView(init: ScrollView.() -> Unit) : ScrollView {
    val scroll = ScrollView(this)
    scroll.init()
    return scroll
}

fun View.scrollView(init: ScrollView.() -> Unit) : ScrollView {
    val scroll = ScrollView(context)
    scroll.init()
    return scroll
}

fun scrollView(ctx: Context, init: ScrollView.() -> Unit) : ScrollView {
    val scroll = ScrollView(ctx)
    scroll.init()
    return scroll
}

fun RecyclerView.adapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

fun RecyclerView.singleClickable() {
    isMotionEventSplittingEnabled = false
}

fun <T> RecyclerView.adapter(items: MutableList<T>, viewHolderWrapper: ViewHolderWrapper<T>) {
    adapter = CoreAdapter(items, viewHolderWrapper)
}

