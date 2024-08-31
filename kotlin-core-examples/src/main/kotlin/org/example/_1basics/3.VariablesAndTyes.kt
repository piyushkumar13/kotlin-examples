package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 31/08/24.
 */


/*
* In Kotlin, you declare a variable starting with a keyword, val or var, followed by the name of the variable.
* */




fun main() {

    /*
    * Data types in Kotlin are all objects.
    * */

    /* ======================== Constants in Kotlin ===========================*/

    /*
    * Use the val keyword to declare variables that are assigned a value only once.
    * These are immutable, read-only local variables that can’t be reassigned a different value after initialization.
    * */
    val a1: Int = 1
    val b1: Long = 23L
    val c1: String = "Hello"
    val d1: Char = 'P'
    val e1: Float = 2.3f // Since number with "." is double, so we need to specify "f" or "F" with value.
    val f1: Double = 3.2 // By default, number with "." is double.
    val g1: Boolean = true

    // a1 = 2 // It will give error

    println("The value is : $a1")
    println("The value is : $b1")
    println("The value is : $c1")
    println("The value is : $d1")
    println("The value is : $e1")
    println("The value is : $f1")
    println("The value is : $g1")

    /* ======================== Variables in Kotlin ===========================*/

    /*
    * Use the var keyword to declare variables that can be reassigned.
    * These are mutable variables, and you can change their values after initialization:
    * */

    var a2: Int = 1
    var b2: Long = 23L
    var c2: String = "Hello"
    var d2: Char = 'P'
    var e2: Float = 2.3f // Since number with "." is double, so we need to specify "f" or "F" with value.
    var f2: Double = 3.2 // By default, number with "." is double.
    var g2: Boolean = true

    a2 = 2 // Variable can be reassigned

    println("The variable is : $a2")
    println("The variable is : $b2")
    println("The variable is : $c2")
    println("The variable is : $d2")
    println("The variable is : $e2")
    println("The variable is : $f2")
    println("The variable is : $g2")


    /*There is no default value assigned to variables, so we need to assign them mandatory before use otherwise will get compilation error. */

    var a3: Int
    val b3: String
    // println(a3) // Since we are using a3 without initializing it - Will give compilation error.
    // print(b3) // Since we are using b3 without initializing it -Will give compilation error.

    /* Type Inference - we don't have to explicitly specify the type of the variable or val, its type will be inferred based on the assigned value. */

    var a4 = "Hello" // Kotlin will infer type of a4 as String.
    val b4 = 5 // Kotlin will infer type of b4 as Integer.

    println("Type inference example for String : $a4")
    println("Type inference example for Int : $b4")

}
