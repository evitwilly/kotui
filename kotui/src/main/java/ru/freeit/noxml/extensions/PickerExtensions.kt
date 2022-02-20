package ru.freeit.noxml.extensions

import android.app.Activity
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.Fragment

fun Activity.datePicker(init: DatePicker.() -> Unit) : DatePicker {
    val picker = DatePicker(this)
    picker.init()
    return picker
}

fun Fragment.datePicker(init: DatePicker.() -> Unit) : DatePicker {
    val picker = DatePicker(requireContext())
    picker.init()
    return picker
}

fun View.datePicker(init: DatePicker.() -> Unit) : DatePicker {
    val picker = DatePicker(context)
    picker.init()
    return picker
}

fun Activity.timePicker(init: TimePicker.() -> Unit) : TimePicker {
    val picker = TimePicker(this)
    picker.init()
    return picker
}

fun Fragment.timePicker(init: TimePicker.() -> Unit) : TimePicker {
    val picker = TimePicker(requireContext())
    picker.init()
    return picker
}

fun View.timePicker(init: TimePicker.() -> Unit) : TimePicker {
    val picker = TimePicker(context)
    picker.init()
    return picker
}

