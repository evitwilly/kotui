package ru.freeit.bookstat.presentation.screens.add.dialog

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

abstract class BaseDialogFragment : DialogFragment() {

    fun show(parentFragmentManager: FragmentManager) { show(parentFragmentManager, tag) }

}