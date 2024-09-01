package org.example._2conditionsandloops

/**
 * @author Piyush Kumar.
 * @since 01/09/24.
 */

fun main() {

    val maxValue: Int

    val a = 5
    val b = 6

    /* Conventional way of writing if and else statements. */

    if (b > a) {
        maxValue = b
    } else {
        maxValue = a
    }

    println("Max value is : $maxValue")

    /* Conditional expressions. */

    val minValue: Int =
        if (a < b)
            a // Whatever is the last line in the block will be returned
        else
            b // Whatever is the last line in the block will be returned

    println("The minValue is : $minValue")
    /* Conditional exprression with multiple lines. */

    val minValue2 =
        if (a < b) {
            println("The min value is $a")
            a // Whatever is the last line in the block will be returned
        } else {
            println("The min value is $b")
            b // Whatever is the last line in the block will be returned
        }

    println("The minValu2e is : $minValue2")
}