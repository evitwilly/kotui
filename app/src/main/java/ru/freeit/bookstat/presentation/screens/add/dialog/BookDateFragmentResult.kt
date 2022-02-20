package ru.freeit.bookstat.presentation.screens.add.dialog

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import ru.freeit.bookstat.core.FormattedDate

class BookDateFragmentResult(private val fragmentManager: FragmentManager) {

    fun result(year: Int, month: Int, day: Int) {
        val bundle = bundleOf(yearKey to year, monthKey to month, dayKey to day)
        fragmentManager.setFragmentResult(requestKey, bundle)
    }

    fun onResult(lifecycleOwner: LifecycleOwner, callback: (data: Long) -> Unit) {
        fragmentManager.setFragmentResultListener(requestKey, lifecycleOwner) { _, bundle ->
            val year = bundle.getInt(yearKey, 0)
            val month = bundle.getInt(monthKey, 0)
            val day = bundle.getInt(dayKey, 0)
            callback.invoke(FormattedDate.from(year, month, day).milliseconds())
        }
    }

    companion object {
        const val yearKey = "year_key"
        const val monthKey = "month_key"
        const val dayKey = "day_key"

        const val requestKey = "book_date_fragment_result"
    }
}