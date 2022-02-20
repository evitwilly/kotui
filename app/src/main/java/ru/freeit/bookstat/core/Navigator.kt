package ru.freeit.bookstat.core

import androidx.fragment.app.FragmentManager
import ru.freeit.bookstat.R
import ru.freeit.bookstat.presentation.screens.BaseFragment
import ru.freeit.bookstat.presentation.screens.add.dialog.BaseDialogFragment

interface Navigator {

    fun add(fragment: BaseFragment)
    fun replace(fragment: BaseFragment)
    fun dialog(fragment: BaseDialogFragment)
    fun back()

    class Base(private val fragmentManager: FragmentManager, private val contentViewId: Int) :
        Navigator {
        override fun add(fragment: BaseFragment) {
            fragmentManager.beginTransaction()
                .add(contentViewId, fragment)
                .commit()
        }

        override fun back() {
            fragmentManager.popBackStack()
        }

        override fun replace(fragment: BaseFragment) {
            fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.empty)
                .replace(contentViewId, fragment)
                .addToBackStack(null)
                .commit()
        }

        override fun dialog(fragment: BaseDialogFragment) {
            fragment.show(fragmentManager)
        }

    }

    object Empty : Navigator {
        override fun add(fragment: BaseFragment) {}
        override fun replace(fragment: BaseFragment) {}
        override fun dialog(fragment: BaseDialogFragment) {}
        override fun back() {}
    }
}