package ru.freeit.bookstat.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.freeit.bookstat.R
import ru.freeit.bookstat.core.App
import ru.freeit.bookstat.core.Navigator
import ru.freeit.bookstat.presentation.screens.list.BookListFragment
import ru.freeit.noxml.extensions.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(frameLayout {
            id(R.id.fragment_container)
            layoutParams(viewGroupLayoutParams().match())
        })

        val navigator = Navigator.Base(supportFragmentManager, R.id.fragment_container)
        (application as App).initNavigator(navigator)

        if (savedInstanceState == null) {
            navigator.add(BookListFragment())
        }
    }
}