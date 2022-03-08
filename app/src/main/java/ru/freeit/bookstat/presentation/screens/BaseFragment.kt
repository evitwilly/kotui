package ru.freeit.bookstat.presentation.screens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import ru.freeit.bookstat.R
import ru.freeit.bookstat.core.App
import ru.freeit.bookstat.core.Navigator
import ru.freeit.bookstat.presentation.toolbar.Toolbar
import ru.freeit.noxml.extensions.*

abstract class BaseFragment : Fragment() {

    protected open val isBack : Boolean = false
    protected open val isEndButton: Boolean = false

    protected val app: App by lazy { (requireContext().applicationContext as App) }
    protected val mainHandler by lazy { Handler(Looper.getMainLooper()) }
    protected val navigator: Navigator by lazy { app.navigator() }
    protected val appFonts by lazy { app.appFonts() }

    abstract fun view(savedInstanceState: Bundle?): View

    private var toolbar: Toolbar? = null

    protected fun titleClick(click: () -> Unit) { toolbar?.onClick = { click.invoke() } }
    protected fun title(str: String) { toolbar?.title(str) }
    protected fun title(@StringRes resId: Int) { toolbar?.title(getString(resId)) }
    protected fun endButtonIcon(@DrawableRes drawableRes: Int) { toolbar?.endButtonImg(drawableRes) }
    protected fun endButtonClick(listener: () -> Unit) { toolbar?.endButtonClick(listener) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        val toolbar = Toolbar(requireContext(), appFonts)
        this.toolbar = toolbar
        if (isBack) toolbar.showBackButton() else toolbar.hideBackButton()
        if (isEndButton) toolbar.showEndButton() else toolbar.hideEndButton()
        toolbar.onBack(parentFragmentManager::popBackStack)

        val view = view(savedInstanceState)
        view.layoutParams(linearLayoutCompatParams()
            .matchWidth()
            .wrapHeight()
            .weight(1f))

        return linearLayout {
            bg(R.color.white)
            vertical()
            addView(toolbar, view)
        }
    }

    override fun onDestroyView() {
        this.toolbar = null
        super.onDestroyView()
    }

}