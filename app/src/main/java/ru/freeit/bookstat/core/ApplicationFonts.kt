package ru.freeit.bookstat.core

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface

class ApplicationFonts(private val assets: AssetManager) {

    private val bold = "Montserrat-Bold.ttf"
    private val light = "Montserrat-Light.ttf"
    private val medium = "Montserrat-Medium.ttf"
    private val regular = "Montserrat-Regular.ttf"

    fun bold() : Typeface = Typeface.createFromAsset(assets, bold)
    fun light() : Typeface = Typeface.createFromAsset(assets, light)
    fun medium() : Typeface = Typeface.createFromAsset(assets, medium)
    fun regular() : Typeface = Typeface.createFromAsset(assets, regular)
}