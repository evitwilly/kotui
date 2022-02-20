package ru.freeit.bookstat.presentation.screens.stat

import android.os.Bundle
import android.view.View
import ru.freeit.bookstat.R
import ru.freeit.bookstat.data.repo.BookRepository
import ru.freeit.bookstat.presentation.screens.BaseFragment
import ru.freeit.noxml.extensions.*

class StatFragment : BaseFragment() {

    override val isBack: Boolean = true

    override fun view(savedInstanceState: Bundle?): View {
        title(R.string.statistics)

        val bookRepository = BookRepository.Base(app.executor(), app.internalStorage())

        return scrollView {
            addView(linearLayout {
                padding(dp(16))
                vertical()
                bookRepository.read {  books ->
                    mainHandler.post {
                        books.bookCountByYear().forEach { (year, count) ->
                            val yearTextView = text {
                                typeface(appFonts.medium())
                                colorRes(R.color.black)
                                fontSize(26f)
                                text(year)
                                layoutParams(linearLayoutParams()
                                    .matchWidth()
                                    .wrapHeight()
                                    .marginBottom(dp(8))
                                    .build())
                            }
                            val countTextView = text {
                                typeface(appFonts.regular())
                                fontSize(18f)
                                colorRes(R.color.black)
                                text(getString(R.string.book_count, count))
                                layoutParams(linearLayoutParams()
                                    .matchWidth()
                                    .wrapHeight()
                                    .marginBottom(dp(16))
                                    .build())
                            }
                            addView(yearTextView, countTextView)
                        }
                    }
                }
            })
            layoutParams(viewGroupLayoutParams().match().build())
        }
    }
}