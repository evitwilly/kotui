package ru.freeit.bookstat.presentation.screens.add.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import ru.freeit.bookstat.core.FormattedDate
import ru.freeit.noxml.extensions.datePicker

class BookDateDialog() : BaseDialogFragment() {

    constructor(date: Long) : this() {
        arguments = bundleOf(dateKey to date)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val formattedDate = FormattedDate(requireArguments().getLong(dateKey, 0L))
        val fragmentResult = BookDateFragmentResult(parentFragmentManager)
        return datePicker {
            init(formattedDate.year(), formattedDate.month(), formattedDate.day()) { _, year, monthOfYear, dayOfMonth ->
                fragmentResult.result(year, monthOfYear, dayOfMonth)
            }
        }
    }

    companion object {
        const val dateKey = "book_date_dialog_date_key"
    }
}