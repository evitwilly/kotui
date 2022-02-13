package ru.freeit.bookstat.core

import android.app.Application
import ru.freeit.bookstat.data.storage.InternalStorage
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class App : Application() {

    private var navigator : Navigator = Navigator.Empty

    private val executor by lazy {
        Executors.newFixedThreadPool(2)
    }

    private val internalStorage by lazy {
        InternalStorage.Base(applicationContext.filesDir)
    }

    private val appFonts by lazy {
        ApplicationFonts(assets)
    }

    fun initNavigator(navigator: Navigator) {
        this.navigator = navigator
    }

    fun internalStorage() = internalStorage
    fun executor() : ExecutorService = executor
    fun appFonts() = appFonts
    fun navigator() = navigator
}