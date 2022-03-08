package ru.freeit.bookstat.presentation.screens.add

import android.os.Bundle
import android.view.Gravity
import android.view.View
import ru.freeit.bookstat.R
import ru.freeit.bookstat.core.FormattedDate
import ru.freeit.bookstat.data.model.Book
import ru.freeit.bookstat.data.repo.BookRepository
import ru.freeit.bookstat.presentation.screens.BaseFragment
import ru.freeit.bookstat.presentation.screens.add.dialog.BookDateDialog
import ru.freeit.bookstat.presentation.screens.add.dialog.BookDateFragmentResult
import ru.freeit.bookstat.presentation.screens.add.view.colors.ColorSource
import ru.freeit.bookstat.presentation.screens.add.view.colors.ColorsView
import ru.freeit.noxml.extensions.*

class AddFragment : BaseFragment() {

    override val isBack = true
    override val isEndButton = true

    private var addedDate = System.currentTimeMillis()

    private fun title() {
        val titleStr = getString(R.string.a_new_book)
        val formattedDate = FormattedDate(addedDate)
        title("$titleStr\n${formattedDate.string()}")
    }

    override fun view(savedInstanceState: Bundle?): View {

        endButtonIcon(R.drawable.ic_check)

        if (savedInstanceState != null) {
            addedDate = savedInstanceState.getLong(dateKey, 0L)
        }
        title()
        titleClick { navigator.dialog(BookDateDialog(addedDate)) }

        val fragmentResult = BookDateFragmentResult(parentFragmentManager)
        fragmentResult.onResult(viewLifecycleOwner) { date ->
            addedDate = date
            title()
        }

        val colorSource = ColorSource.Base()
        val bookRepository = BookRepository.Base(app.executor(), app.internalStorage())

        return linearLayout {
            vertical()

            val colorsView = ColorsView(context, colorSource.colors())
            colorsView.layoutParams(linearLayoutCompatParams()
                .matchWidth().wrapHeight()
                .marginStart(dp(16))
                .marginBottom(dp(8))
                .marginEnd(dp(16)))

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
                    .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL))
            }

            val progress = progressIndicator {
                indeterminate()
                trackColor(R.color.purple_200)
                layoutParams(frameLayoutParams()
                    .wrapWidth().wrapHeight()
                    .marginTop(dp(48))
                    .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL))
                visibility = View.GONE
            }

            endButtonClick {
                bookNameEdit.error = null
                if (!bookNameEdit.text.isNullOrBlank()) {
                    progress.visibility = View.VISIBLE
                    bookRepository.save(Book(bookNameEdit.str(), colorsView.selectedColor(), addedDate)) {
                        handler.post {
                            progress.visibility = View.GONE
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
                layoutParams(linearLayoutCompatParams().matchWidth()
                    .margins(dp(16)).wrapHeight().weight(1f))

                addView(bookNameEdit, progress)
            }

            colorsView.listenSelectedColor { selectedColor ->
                bookCoverFrameLayout.bg(roundedDrawable(selectedColor,  bookCoverRadius))
            }

            addView(bookCoverFrameLayout, colorsView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong(dateKey, addedDate)
    }

    companion object {
        const val dateKey = "add_fragment_date_key"
    }


}