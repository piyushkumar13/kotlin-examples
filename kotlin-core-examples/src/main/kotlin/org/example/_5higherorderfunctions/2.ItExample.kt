package org.example._5higherorderfunctions

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

fun main() {

    val reverseStr1 =
        reverseStr("Hello", { s -> s.reversed() }) // since there is only one parameter we can refer it using "it"
    println("ReverseStr1 : " + reverseStr1)

    val reverseStr2 = reverseStr("Hello", { it.reversed() })
    println("ReverseStr2 : " + reverseStr2)


}

fun reverseStr(str: String, reverse: (String) -> String): String {

    return reverse(str)
}