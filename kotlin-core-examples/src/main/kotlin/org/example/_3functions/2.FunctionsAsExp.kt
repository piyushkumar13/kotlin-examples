package org.example._3functions

/**
 * @author Piyush Kumar.
 * @since 02/09/24.
 */

fun main() {

    val greater1 = greater(2, 5)
    println("greater1 is : $greater1")

    val greater2 = greater2(4, 1)
    println("greater2 is : $greater2")

}

fun greater(a: Int, b: Int): Int = if (a > b) a else b


fun greater2(a: Int, b: Int): Int =
    if (a > b) {
        println("a is greater than b")
        a // whatever is the last statement i.e returned. Here, a is returned.
    } else {
        println("b is greater than a")
        b // whatever is the last statement i.e returned. Here, b is returned.
    }

fun greater3(a: Int, b: Int): Int =
    if (a > b) {
        println("a is greater than b")
        a // whatever is the last statement i.e returned. Here, a is returned.
    } else {
        println("b is greater than a")
        b // whatever is the last statement i.e returned. Here, b is returned.
    }