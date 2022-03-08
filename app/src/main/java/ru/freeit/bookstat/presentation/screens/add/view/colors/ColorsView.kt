package ru.freeit.bookstat.presentation.screens.add.view.colors

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.widget.LinearLayoutCompat
import ru.freeit.bookstat.R
import ru.freeit.noxml.extensions.*

class ColorsView(ctx: Context, private val colors: List<Int>) : LinearLayoutCompat(ctx) {

    private var selected: Int = 0
    private var listener = ColorSelectListener {  }

    private val colorViews = colors.map { color ->
        imageView {
            bgColor(color)
            padding(dp(16))
            imgColor(colorBy(R.color.white))
            isClickable = true
        }
    }

    fun selectedColor() = colors[selected]
    fun listenSelectedColor(listener: ColorSelectListener) {
        this.listener = listener
    }

    private fun changeImgWithSelectedIndex() {
        colorViews.forEach { view -> view.empty() }
        colorViews[selected].img(R.drawable.ic_check)
    }

    init {
        id(R.id.color_view)
        horizontal()
        afterMeasure {
            val size = width / colors.size
            colorViews.forEachIndexed { index, view ->
                changeImgWithSelectedIndex()
                view.onClick = {
                    selected = index
                    listener.onSelect(colors[index])
                    changeImgWithSelectedIndex()
                }
                view.layoutParams(linearLayoutCompatParams().width(size).height(size))
                addView(view)
            }
        }
    }

    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle()
        bundle.putParcelable(superStateKey, super.onSaveInstanceState())
        bundle.putInt(selectedColorKey, selected)
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            selected = state.getInt(selectedColorKey)
            listener.onSelect(colors[selected])
            super.onRestoreInstanceState(state.getParcelable(superStateKey))
        } else {
            super.onRestoreInstanceState(state)
        }
    }

    companion object {
        private const val superStateKey = "super_state"
        private const val selectedColorKey = "selected_color"
    }
}