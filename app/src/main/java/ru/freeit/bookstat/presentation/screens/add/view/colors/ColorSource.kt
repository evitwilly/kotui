package ru.freeit.bookstat.presentation.screens.add.view.colors

import android.graphics.Color

interface ColorSource {

    fun colors() : List<Int>
    fun color(index: Int) : Int

    class Base : ColorSource {
        private val blue700 = Color.parseColor("#210070")
        private val green300 = Color.parseColor("#213970")
        private val yellow500 = Color.parseColor("#f3b41a")
        private val orange500 = Color.parseColor("#e71989")
        private val pink100 = Color.parseColor("#ffa781")
        private val blue300 = Color.parseColor("#00e1d9")

        private val colors = listOf(blue700, green300, yellow500, orange500, pink100, blue300)

        override fun colors() = colors
        override fun color(index: Int) = colors[index]
    }
}