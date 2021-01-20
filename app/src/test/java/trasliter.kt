import java.util.*

internal object Translit {
    private val letters: MutableMap<String, String?> =
        HashMap()

    fun toTranslit(text: String): String {
        val sb = StringBuilder(text.length)
        for (i in 0 until text.length) {
            val l = text.substring(i, i + 1)
            if (letters.containsKey(l)) {
                sb.append(letters[l])
            } else {
                sb.append(l)
            }
        }
        return sb.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val test = "Алма, АЛМА, жақсы, ЖаҚсЫ"
        println("toTranslit(test) = " + toTranslit(test))
    }

    init {
        letters["а"] = "a"
        letters["ә"] = "a'"
        letters["б"] = "b"
        letters["д"] = "d"
        letters["е"] = "e"
        letters["ф"] = "f"
        letters["г"] = "g"
        letters["ғ"] = "g'"
        letters["х"] = "h"
        letters["h"] = "h"
        letters["і"] = "i"
        letters["и"] = "i'"
        letters["й"] = "i'"
        letters["ж"] = "j"
        letters["к"] = "k"
        letters["л"] = "l"
        letters["м"] = "m"
        letters["н"] = "n"
        letters["ң"] = "n'"
        letters["о"] = "o"
        letters["ө"] = "o'"
        letters["п"] = "p"
        letters["қ"] = "q"
        letters["р"] = "r"
        letters["с"] = "c"
        letters["ш"] = "s'"
        letters["ч"] = "c'"
        letters["т"] = "t"
        letters["ұ"] = "u"
        letters["ү"] = "u'"
        letters["в"] = "v"
        letters["ы"] = "y"
        letters["у"] = "y'"
        letters["з"] = "z"

    }
}