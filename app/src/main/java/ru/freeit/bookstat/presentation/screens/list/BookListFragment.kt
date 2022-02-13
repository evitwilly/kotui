package ru.freeit.bookstat.presentation.screens.list

import android.content.Context
import android.view.Gravity
import android.view.View
import ru.freeit.bookstat.R
import ru.freeit.bookstat.data.model.Book
import ru.freeit.bookstat.data.repo.BookRepository
import ru.freeit.bookstat.data.model.Books
import ru.freeit.bookstat.presentation.screens.BaseFragment
import ru.freeit.bookstat.presentation.screens.add.AddFragment
import ru.freeit.bookstat.presentation.screens.stat.StatFragment
import ru.freeit.noxml.extensions.*
import ru.freeit.noxml.extensions.adapter.ViewHolderWrapper
import java.util.*

class BookListFragment : BaseFragment() {

    override val isEndButton = true

    override fun view(): View {
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

            bookRepository.read { books ->
                val calendar = Calendar.getInstance()
                val items = books.items().toMutableList()
                list.adapter(items, object: ViewHolderWrapper<Book>() {
                    override fun view(ctx: Context): View {
                        val bookNameText = text {
                            colorRes(R.color.white)
                            fontSize(19f)
                            textCenter()
                            typeface(appFonts.medium())
                            layoutParams(frameLayoutParams()
                                .wrapWidth().wrapHeight()
                                .marginTop(dp(32))
                                .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
                                .build())
                        }
                        val dateText = text {
                            colorRes(R.color.white)
                            fontSize(14f)
                            typeface(appFonts.medium())
                            layoutParams(frameLayoutParams()
                                .wrapWidth().wrapHeight()
                                .gravity(Gravity.BOTTOM or Gravity.END)
                                .build())
                        }

                        val deleteButton = imageView {
                            img(R.drawable.ic_delete)
                            clickable()
                            ripple(R.color.purple_200, dp(16))
                            layoutParams(frameLayoutParams()
                                .width(dp(24)).height(dp(24))
                                .gravity(Gravity.START or Gravity.TOP)
                                .build())
                        }

                        val frameLayout = frameLayout {
                            padding(dp(8))
                            layoutParams(recyclerLayoutParams()
                                .matchWidth().height(dp(250))
                                .build())

                            addView(bookNameText, dateText, deleteButton)
                        }

                        listenItem { index, item, listeners  ->
                            item.roundedDrawableWithSelectedColor(frameLayout, dp(20f))
                            item.bookName(bookNameText)
                            item.addedDate(dateText, calendar)

                            deleteButton.click {
                                bookRepository.save(Books(items - item)) {
                                    mainHandler.post {
                                        listeners.itemRemoved(index)
                                    }
                                }
                            }
                        }

                        return frameLayout
                    }
                })
            }

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