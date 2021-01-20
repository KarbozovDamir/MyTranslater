package kz.company.mytranslater

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val CYRRILIC_VALUE = "INPUT_VALUE"
private const val LATIN_VALUE = "LATIN_VALUE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        send_btn.setOnClickListener {
            var arg = editText.text.toString()
            var latin : String = ""
            latin =  transSents(arg)
            translatedText.text = latin
            showText.text = arg
            editText.text.clear()
        }
    }

    fun transSents(arg : String) : String {

        var newWord : String = ""
        var accumLetters : String = ""
        for ((_, letter) in arg.withIndex()) {
            if ( letter >= 32.toChar() && letter <= 64.toChar()) {
                newWord += letter.toString()

            }else if ( letter > 1000.toChar() && letter < 1300.toChar()) {
                accumLetters  = checkLetter(letter.toString())
                newWord += accumLetters
            }else if  ( letter >= 65.toChar() && letter <= 122.toChar() ) {
                newWord = "enter cyrillic symbols.."
            }
        }
        return newWord
    }

    fun checkLetter(s : String) : String {
        var latinLetter: String = ""

        when (s) {
            "а" -> latinLetter = "a"
            "ә" -> latinLetter = "á"
            "б" -> latinLetter = "b"
            "в" -> latinLetter = "v"
            "г" -> latinLetter = "g"
            "д" -> latinLetter = "d"
            "е" -> latinLetter = "e"
            "ж" -> latinLetter = "j"
            "з" -> latinLetter = "z"
            "и" -> latinLetter = "i"
            "й" -> latinLetter = "i"
            "к" -> latinLetter = "k"
            "қ" -> latinLetter = "q"
            "л" -> latinLetter = "l"
            "м" -> latinLetter = "m"
            "н" -> latinLetter = "n"
            "ң" -> latinLetter = "ń"
            "о" -> latinLetter = "o"
            "ө" -> latinLetter = "ó"
            "п" -> latinLetter = "p"
            "р" -> latinLetter = "r"
            "с" -> latinLetter = "s"
            "т" -> latinLetter = "t"
            "у" -> latinLetter = "ý"
            "ұ" -> latinLetter = "u"
            "ү" -> latinLetter = "ú"
            "ф" -> latinLetter = "f"
            "х" -> latinLetter = "h"
            "һ" -> latinLetter = "h"
            "ч" -> latinLetter = "ch"
            "ш" -> latinLetter = "sh"
            "ы" -> latinLetter = "y"
            "і" -> latinLetter = "i"
            "А" -> latinLetter = "A"
            "Ә" -> latinLetter = "Á"
            "Б" -> latinLetter = "B"
            "В" -> latinLetter = "V"
            "Г" -> latinLetter = "G"
            "Ғ" -> latinLetter = "Ǵ"
            "Д" -> latinLetter = "D"
            "Е" -> latinLetter = "Е"
            "Ж" -> latinLetter = "J"
            "З" -> latinLetter = "Z"
            "И" -> latinLetter = "I"
            "Й" -> latinLetter = "I"
            "К" -> latinLetter = "K"
            "Қ" -> latinLetter = "Q"
            "Л" -> latinLetter = "L"
            "М" -> latinLetter = "M"
            "Н" -> latinLetter = "N"
            "Ң" -> latinLetter = "Ń"
            "О" -> latinLetter = "O"
            "Ө" -> latinLetter = "Ó"
            "П" -> latinLetter = "P"
            "Р" -> latinLetter = "R"
            "С" -> latinLetter = "S"
            "Т" -> latinLetter = "T"
            "У" -> latinLetter = "Ý"
            "Ұ" -> latinLetter = "U"
            "Ү" -> latinLetter = "Ú"
            "Ф" -> latinLetter = "F"
            "Х" -> latinLetter = "H"
            "Һ" -> latinLetter = "H"
            "Ч" -> latinLetter = "Ch"
            "Ш" -> latinLetter = "Sh"
            "Ы" -> latinLetter = "Y"
            "І" -> latinLetter = "I"
            else -> {
                ""
            }
        }
        return latinLetter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString("INPUT_VALUE", showText.text.toString())
            putString("LATIN_VALUE", translatedText.text.toString())
        }
        if (outState != null) {
            super.onSaveInstanceState(outState)
        }
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            showText.text = savedInstanceState?.getString("INPUT_VALUE")
            translatedText.text = savedInstanceState?.getString("LATIN_VALUE")
        }
    }

}

