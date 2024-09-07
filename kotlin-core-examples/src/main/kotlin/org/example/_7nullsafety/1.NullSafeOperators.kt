package org.example._7nullsafety

/**
 * @author Piyush Kumar.
 * @since 08/09/24.
 */

fun main(){

    val nullableName: String? = null // ? operator makes the val or var as nullable since by default in Kotlin, var or val must have some default value, it cannot be null.
    val name: String? = "Piyush"


    println("======== Safe call operator ?. ===========")

    /* Following statements returns the length if name is not null else returns null. Basically, if name is null, length does not get evaluated. */
    println("nullableName : ${nullableName?.length}")
    println("Name : ${name?.length}")


    println("======== Safe call operator with let ===========")

    /* let block executed if name is not null else does not get executed. */
    nullableName?.let {
        println("nullableName : ${nullableName.length}")

    }
    name?.let {
        println("nullableName : ${name.length}")
    }

    println("======== Elvis operator ?: ===========")

    val length1 = nullableName?.length ?: -1
    val length2 = name?.length ?: -1

    println("length1 : $length1")
    println("length2 : $length2")

    println("======== Non-Null assertion operator !! ===========")

    /* Use it when you are 100% sure that value is not null else throws Null pointer exception. */

    println("Name : ${name!!.length}")
    println("nullableName : ${nullableName!!.length}") // Throws null pointer exception
}

