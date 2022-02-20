# kotui

kotui - a set of Kotlin extensions to create UI on Android without using xml

It looks like an [Anko library](https://github.com/Kotlin/anko)

#### Simple screen:

    setContentView(frameLayout {
    
      val text1 = text {
        fontSize(18f)
        text("Hello, World!")
        colorRes(R.color.black)
        layoutParams(frameLayoutParams()
            .wrapWidth().wrapHeight()
            .gravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
            .marginTop(dp(16))
            .build())
      }
      
      val button1 = button {
        fontSize(18f)
        text("Click")
        colorRes(R.color.black)
        click { toast("Hello, World!") }
        layoutParams(frameLayoutParams()
            .wrapWidth().wrapHeight()
            .gravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL)
            .marginBottom(dp(16))
            .build())
      }
      
      addView(text1, button1)
    })

#### Create FloatingActionButton:


      val floatingButton = floatingButton {
          img(R.drawable.ic_add)
          imgColor(R.color.white)
          tint(R.color.purple_200)
          size(dp(56))
          click { toast(R.string.helllo_world) }
          layoutParams(frameLayoutParams()
              .wrapWidth()
              .wrapHeight()
              .marginBottom(dp(16))
              .marginEnd(dp(16))
              .gravity(Gravity.END or Gravity.BOTTOM)
              .build())
      }
      
#### LinearLayout:

    setContentView(linearLayout { 
      vertical()
      padding(dp(16))

      val edit1 = edit {
        hint("Your name:")
        layoutParams(linearLayoutParams().matchWidth()
            .marginBottom(dp(8))
            .wrapHeight().build())
      }

      val edit2 = edit {
        hint("Your surname:")
        layoutParams(linearLayoutParams().matchWidth().wrapHeight().build())
      }

      addView(edit1, edit2)
    })
      
      
#### RecyclerView:

    setContentView(list {
      adapter(mutableListOf("Twilight Sparkle", "Starlight Glimmer", "Sunset Shimmer"), object: ViewHolderWrapper<String>() {
        override fun view(ctx: Context): View {
            return text {
                fontSize(18f)
                padding(dp(8))
                colorRes(R.color.black)
                listenItem { _, ponyName, _ ->
                    text(ponyName)
                }
            }
        }
      })
    })

#### More examples:

[see my application code](https://github.com/KiberneticWorm/Bookstat/tree/master/app)

## Download

