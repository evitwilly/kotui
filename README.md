# Bookstat

In this app I don't use any **xml layout.**

I created special **Kotlin extensions and classes** to make it easier to create views in code.

You can use my mini library.

**1.** Add it in your root build.gradle at the end of repositories:

      allprojects {
            repositories {
                  ...
                  maven { url 'https://jitpack.io' }
            }
      }

**2.** Add the dependency:

      dependencies {
            implementation 'com.github.KiberneticWorm:Bookstat:ece888ced1'
      }

It looks like an [Anko library](https://github.com/Kotlin/anko)

**Example №1:**


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
      
**Example №2:**

      linearLayout {
          padding(dp(16))
          vertical()

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
  
#### More examples:

[see my application code](https://github.com/KiberneticWorm/Bookstat/tree/master/app)
  
# Screens

<table>
  <tr>
    <td><img src="https://github.com/KiberneticWorm/Bookstat/blob/master/screens/screen1.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/Bookstat/blob/master/screens/screen2.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/Bookstat/blob/master/screens/screen3.png" /></td>
    <td><img src="https://github.com/KiberneticWorm/Bookstat/blob/master/screens/screen4.png" /></td>
  </tr>
</table>

