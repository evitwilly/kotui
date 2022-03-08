package ru.freeit.bookstat.presentation.screens.list

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.bookstat.R
import ru.freeit.bookstat.core.ApplicationFonts
import ru.freeit.bookstat.data.model.Book
import ru.freeit.noxml.extensions.*

class BookViewHolderViews(
    val root: FrameLayout,
    val bookName: TextView,
    val dateText: TextView,
    val deleteButton: ImageView
)

class BookViewHolder(private val views: BookViewHolderViews) : RecyclerView.ViewHolder(views.root) {

    fun bind(book: Book, delete: (book: Book) -> Unit) {
        book.roundedDrawableWithSelectedColor(views.root, views.root.context.dp(20f))
        book.bookName(views.bookName)
        book.addedDate(views.dateText)

        views.deleteButton.onClick = { delete.invoke(book) }
    }

    companion object {
        fun from(parent: ViewGroup, appFonts: ApplicationFonts) : BookViewHolder {
            val ctx = parent.context
            val bookNameText = text(ctx) {
                colorRes(R.color.white)
                fontSize(19f)
                textCenter()
                typeface(appFonts.medium())
                layoutParams(
                    frameLayoutParams().wrapWidth().wrapHeight().marginTop(dp(32))
                        .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
                )
            }
            val dateText = text(ctx) {
                colorRes(R.color.white)
                fontSize(14f)
                typeface(appFonts.medium())
                layoutParams(
                    frameLayoutParams().wrapWidth().wrapHeight().gravity(Gravity.BOTTOM or Gravity.END)
                )
            }

            val deleteButton = imageView(ctx) {
                img(R.drawable.ic_delete)
                isClickable = true
                ripple(R.color.purple_200, dp(16))
                layoutParams(frameLayoutParams().width(dp(24)).height(dp(24))
                    .gravity(Gravity.START or Gravity.TOP))
            }

            val frameLayout = frameLayout(ctx) {
                padding(dp(8))
                layoutParams(recyclerLayoutParams().matchWidth().height(dp(250)))
                addView(bookNameText, dateText, deleteButton)
            }

            return BookViewHolder(BookViewHolderViews(frameLayout, bookNameText, dateText, deleteButton))
        }
    }
}