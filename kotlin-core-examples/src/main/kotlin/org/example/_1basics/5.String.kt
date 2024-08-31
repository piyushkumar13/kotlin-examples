package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 31/08/24.
 */


fun main() {

    /* Printing chars in string. */
    println("========= Printing chars in string ========= ")

    val str1: String = "Piyush"

    for (c in str1) {

        println(c)
    }

    /* Multiline strings. */

    println("========== Printing multiline string ===========")

    val str2 = """
        This is Piyush.
        Practicing kotlin.
        Kotlin is good
    """.trimIndent()

    println(str2)

    /* String template. */

    println("============== String template example =========== ")
    val str3 = "World"
    val str4 = "Hello $str3"
    println(str4)

    println("${str4.replace("Hello", "Hi")} - This is string template with expression.")
}