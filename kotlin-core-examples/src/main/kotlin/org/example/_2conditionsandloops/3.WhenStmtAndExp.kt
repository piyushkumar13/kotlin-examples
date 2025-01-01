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


    /*
    * Using when as a replacement for an if-else-if chain:
    * We can use when as a replacement for if-else-if.
    * If no argument is supplied then the branch conditions are simply boolean expressions,
    * and a branch is executed only when its condition is true:
    * */
    fun isOdd(x: Int) = x % 2 != 0
    fun isEven(x: Int) = x % 2 == 0

    var num = 8
    when {
        isOdd(num) -> println("Odd")
        isEven(num) -> println("Even")
        else -> println("Neither even nor odd")
    }

    /*
    * Check that a string contains a particular prefix or suffix:
    * We can also check prefix or suffix in a given string by the below method.
    * If the string contains the prefix or suffix then it will return the Boolean value true else return false.
    * */
    fun hasPrefix(company: Any):Boolean{
        return when (company) {
            is String -> company.startsWith("GeeksforGeeks")
            else -> false
        }
    }

    var company = "GeeksforGeeks a computer science portal"
    var result = hasPrefix(company)
    if(result) {
        println("Yes, string started with GeeksforGeeks")
    }
    else {
        println("No, String does not started with GeeksforGeeks")
    }

}