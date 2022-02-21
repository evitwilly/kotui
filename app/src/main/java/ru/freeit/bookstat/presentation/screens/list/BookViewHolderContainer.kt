package ru.freeit.bookstat.presentation.screens.list

import android.content.Context
import android.view.Gravity
import android.view.View
import ru.freeit.bookstat.R
import ru.freeit.bookstat.core.ApplicationFonts
import ru.freeit.bookstat.data.model.Book
import ru.freeit.noxml.extensions.*
import ru.freeit.noxml.extensions.adapter.ViewHolderContainer

class BookViewHolderContainer(
    private val appFonts: ApplicationFonts,
    private val delete: (book: Book) -> Unit
) : ViewHolderContainer<Book>() {

    override fun view(ctx: Context): View {
        val bookNameText = text(ctx) {
            colorRes(R.color.white)
            fontSize(19f)
            textCenter()
            typeface(appFonts.medium())
            layoutParams(
                frameLayoutParams()
                    .wrapWidth().wrapHeight()
                    .marginTop(dp(32))
                    .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
                    .build()
            )
        }
        val dateText = text(ctx) {
            colorRes(R.color.white)
            fontSize(14f)
            typeface(appFonts.medium())
            layoutParams(
                frameLayoutParams()
                    .wrapWidth().wrapHeight()
                    .gravity(Gravity.BOTTOM or Gravity.END)
                    .build()
            )
        }

        val deleteButton = imageView(ctx) {
            img(R.drawable.ic_delete)
            clickable()
            ripple(R.color.purple_200, dp(16))
            layoutParams(
                frameLayoutParams()
                    .width(dp(24)).height(dp(24))
                    .gravity(Gravity.START or Gravity.TOP)
                    .build()
            )
        }

        val frameLayout = frameLayout(ctx) {
            padding(dp(8))
            layoutParams(
                recyclerLayoutParams()
                    .matchWidth().height(dp(250))
                    .build()
            )

            addView(bookNameText, dateText, deleteButton)
        }

        listenItem { _, item  ->
            item.roundedDrawableWithSelectedColor(frameLayout, ctx.dp(20f))
            item.bookName(bookNameText)
            item.addedDate(dateText)

            deleteButton.click { delete.invoke(item) }
        }

        return frameLayout
    }
}