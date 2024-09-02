package org.example._2conditionsandloops

/**
 * @author Piyush Kumar.
 * @since 01/09/24.
 */


fun main() {

    val x = 2

    /* When statement is the replacement of switch statement in Kotlin. */
    when (x) {
        1 -> println("x is 1")
        2 -> {
            println("Block with multiple lines.")
            println("x is 2")
        }

        in 3..5 -> {
            println("x is in range 3-5.")
        }
        is Number -> {
            println("x is Number")
        }

        else -> {
            println("x is nowhere defined in when statement")
        }
    }

    /* When statement as expressions. */


    val str: String = when (x) {
        1 -> "x is 1"
        2 -> {
            "Block with multiple lines."
            "x is 2" // If we have multiple lines, the last statement in the block will be returned.
        }

        in 3..5 -> "x is in range 3-5."
        else -> "x is nowhere defined in when statement"
    }

    println("Str is : $str")
}