package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 31/08/24.
 */

fun main() {

    println("This is the example of standard input and output")

    println("Reading input from the console")

    /* The readln() function reads from the standard input. This function reads the entire line the user enters as a string. */
    val readInput = readln()

    println("Read input from console is " + readInput)

    // Reads a string and returns null if the input can't be converted into an integer. For example: Hi there!
    val wrongInt = readln().toIntOrNull()
    println(wrongInt)

    // Reads a string that can be converted into an integer and returns an integer. For example: 13
    val correctInt = readln().toIntOrNull()
    println(correctInt)
}