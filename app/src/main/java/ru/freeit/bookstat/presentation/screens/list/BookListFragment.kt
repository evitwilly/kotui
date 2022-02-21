package ru.freeit.bookstat.presentation.screens.list

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import ru.freeit.bookstat.R
import ru.freeit.bookstat.data.model.Book
import ru.freeit.bookstat.data.repo.BookRepository
import ru.freeit.bookstat.presentation.screens.BaseFragment
import ru.freeit.bookstat.presentation.screens.add.AddFragment
import ru.freeit.bookstat.presentation.screens.list.recyclerview.GridItemDecoration
import ru.freeit.bookstat.presentation.screens.stat.StatFragment
import ru.freeit.noxml.extensions.*
import java.util.*

class BookListFragment : BaseFragment() {

    override val isEndButton = true

    override fun view(savedInstanceState: Bundle?): View {
        title(R.string.books)
        endButtonIcon(R.drawable.ic_stat)
        endButtonClick { navigator.replace(StatFragment()) }

        val bookRepository = BookRepository.Base(app.executor(), app.internalStorage())

        val sixteenDp = dp(16)
        return frameLayout {
            val list = list {
                grid(2)
                layoutParams(frameLayoutParams().matchWidth().matchHeight()
                    .margins(sixteenDp, sixteenDp, sixteenDp, sixteenDp)
                    .build())
                itemDecoration(GridItemDecoration())
            }

            val adapter = list.adapter(object: DiffUtil.ItemCallback<Book>() {
                override fun areItemsTheSame(oldItem: Book, newItem: Book) = oldItem.isItemTheSame(newItem)
                override fun areContentsTheSame(oldItem: Book, newItem: Book) = oldItem.isContentTheSame(newItem)
            }, BookViewHolderContainer(appFonts) { book -> bookRepository.remove(book) })

            bookRepository.read { books -> adapter.submitList(books.items()) }

    val floatingButton = floatingButton {
        img(R.drawable.ic_add)
        imgColor(R.color.white)
        tint(R.color.purple_200)
        size(dp(56))
        click { navigator.replace(AddFragment()) }
        layoutParams(frameLayoutParams()
            .wrapWidth()
            .wrapHeight()
            .marginBottom(dp(16))
            .marginEnd(dp(16))
            .gravity(Gravity.END or Gravity.BOTTOM)
            .build())
    }

            addView(list, floatingButton)
        }
    }
}