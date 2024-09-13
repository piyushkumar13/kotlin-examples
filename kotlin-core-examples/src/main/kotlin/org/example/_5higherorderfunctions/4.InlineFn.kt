package org.example._5higherorderfunctions

/**
 * @author Piyush Kumar.
 * @since 13/09/24.
 */

/* An inline function is declared by using a keyword "inline".
* Inline functions enhances the performance of higher order functions. It basically tells the compiler wherever inline function
* is being called, replace that call with the definition of the function.
* */

fun main() {

    calculateTime {
        println("something without inline")
    }

    calculateTime2 { // this call replaces the call with the lines of code in this function.
        println("something with inline")
    }

}

fun calculateTime(fn: () -> Unit) { // Kotlin creates a class which wraps the function to pass that to lambda function, which is inefficient.

    val startTime = System.currentTimeMillis()
    fn()
    val endTime = System.currentTimeMillis()

    println("Time taken : ${endTime - startTime}")
}


/* Here, in this case Kotlin will not create a class to pass to lambda function.
 Rather function call will be replaced by the function lines of codes. */
inline fun calculateTime2(fn: () -> Unit) {

    val startTime = System.currentTimeMillis()
    fn()
    val endTime = System.currentTimeMillis()

    println("Time taken : ${endTime - startTime}")
}