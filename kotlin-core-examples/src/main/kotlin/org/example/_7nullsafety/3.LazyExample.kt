package org.example._7nullsafety

/**
 * @author Piyush Kumar.
 * @since 08/09/24.
 */

/*
* Lazy initialization was designed to prevent unnecessary initialization of object i.e un-necessary allocation of memory.
* Variable will not be initialized(allocated memory) unless you use it in the code.
* It is initialized only once. Next time when you use it, you get the value from the cache memory.
* It is thread safe -> It is initialized in the thread where it is used for the first time and other threads use the same
* value stored in the cache.
*
* The variable can be var or val.
* The variable can be of nullable or non-nullable data type.
* */

val pi: Float by lazy { 3.14f }

fun main(){

    println("Find area ::: ")

    val area = pi * 4 * 4 // Pi will be allocated memory at this point not at the point where it was declared.

    println("area : $area")
}