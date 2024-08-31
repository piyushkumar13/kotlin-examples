package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 30/08/24.
 */


/* Entry points in Kotlin program.
* In Kotlin, main function is the entry point. The main function in Kotlin is not required to be wrapped within a class.
* Kotlin behind the scene creates the class internally and wraps this main() function in it.
* */



/* There are two syntax of main function. https://kotlinlang.org/docs/basic-syntax.html#program-entry-point */
/* ================ Main function syntax 1 ================= */

fun main(){
    println("Hello from main without args.")
}

/* ================ Main function syntax 2 ================ */

fun main(args: Array<String>){

    println("Hello from main with args.")
}