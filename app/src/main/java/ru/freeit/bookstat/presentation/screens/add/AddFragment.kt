package ru.freeit.bookstat.presentation.screens.add

import android.view.Gravity
import android.view.View
import ru.freeit.bookstat.R
import ru.freeit.bookstat.core.App
import ru.freeit.bookstat.data.model.Book
import ru.freeit.bookstat.data.repo.BookRepository
import ru.freeit.bookstat.presentation.screens.BaseFragment
import ru.freeit.bookstat.presentation.screens.add.view.colors.ColorSource
import ru.freeit.bookstat.presentation.screens.add.view.colors.ColorsView
import ru.freeit.bookstat.core.ApplicationFonts
import ru.freeit.noxml.extensions.*

class AddFragment : BaseFragment() {

    override val isBack = true
    override val isEndButton = true

    override fun view(): View {
        title(R.string.a_new_book)
        endButtonIcon(R.drawable.ic_check)

        val colorSource = ColorSource.Base()
        val bookRepository = BookRepository.Base(app.executor(), app.internalStorage())

        return linearLayout {
            vertical()

            val colorsView = ColorsView(context, colorSource.colors())
            colorsView.layoutParams(linearLayoutParams()
                .matchWidth().wrapHeight()
                .marginStart(dp(16))
                .marginBottom(dp(8))
                .marginEnd(dp(16))
                .build())

            val bookNameEdit = edit {
                id(R.id.book_name_edit)
                hint(R.string.book_name)
                hintColor(R.color.white)
                bgNone()
                multiline(15, Gravity.TOP or Gravity.CENTER_HORIZONTAL)
                colorRes(R.color.white)
                fontSize(23f)
                typeface(appFonts.medium())
                layoutParams(frameLayoutParams()
                    .wrapWidth().wrapHeight()
                    .marginTop(dp(32))
                    .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
                    .build())
            }

            val progress = progressIndicator {
                indeterminate()
                trackColor(R.color.purple_200)
                layoutParams(frameLayoutParams()
                    .wrapWidth().wrapHeight()
                    .marginTop(dp(48))
                    .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
                    .build())
                gone()
            }

            endButtonClick {
                bookNameEdit.clearError()
                if (bookNameEdit.existsText()) {
                    progress.visible()
                    bookRepository.save(Book(bookNameEdit.str(), colorsView.selectedColor())) {
                        handler.post {
                            progress.gone()
                            navigator.back()
                        }
                    }
                } else {
                    bookNameEdit.error(R.string.book_name_is_emtpy)
                }
            }

            val bookCoverRadius = dp(20f)
            val bookCoverFrameLayout = frameLayout {
                bg(roundedDrawable(colorsView.selectedColor(), bookCoverRadius))
                padding(dp(8))
                layoutParams(linearLayoutParams().matchWidth()
                    .margins(dp(16))
                    .wrapHeight().weight(1f).build())

                addView(bookNameEdit, progress)
            }

            colorsView.listenSelectedColor { selectedColor ->
                bookCoverFrameLayout.bg(roundedDrawable(selectedColor,  bookCoverRadius))
            }

            addView(bookCoverFrameLayout, colorsView)
        }
    }


}