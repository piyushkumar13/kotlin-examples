package org.example._3functions

/**
 * @author Piyush Kumar.
 * @since 02/09/24.
 */

fun main(args: Array<String>) {

    add(3, 2)
    add2(1, 2)
    val add3 = add3(5, 2)
    println("add3 is : $add3")

}

fun add(
    a: Int,
    b: Int
) { // By default, return type is Unit in Kotlin if we are not returning anything. Unit is like void in java

    println("The sum of a and b in add is : ${a + b}")
}

fun add2(a: Int, b: Int): Unit { // We can also explicitly define Unit as return type in function.

    println("The sum of a and b in add2 is : ${a + b}")
}

fun add3(a: Int, b: Int): Int {

    return a + b
}