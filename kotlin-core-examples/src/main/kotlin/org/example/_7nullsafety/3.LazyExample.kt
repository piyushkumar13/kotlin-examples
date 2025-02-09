package org.example._7nullsafety

import javax.xml.crypto.Data

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
* The variable can be val only. Lazy can only be used with val (immutable) properties, not with var (mutable) properties.
* The variable can be of nullable or non-nullable data type.
* */

val pi: Float by lazy { 3.14f }

fun main(){

    println("Find area ::: ")

    val area = pi * 4 * 4 // Pi will be allocated memory at this point not at the point where it was declared.

    println("area : $area")

    println("Heavy object is ::: ${DatabaseHelper.instance}")
}

/* Singleton Pattern - When creating a singleton instance which is heavy in nature within a class that should only be initialized once
and lazily, ensuring that the heavy instance is not created until it is first accessed. */
object DatabaseHelper {
    val instance by lazy { createDatabaseInstance() }

    private fun createDatabaseInstance(): List<String> {
        // Initialize heavy and complex object
        return listOf("Somthing big list making object heavy")
    }
}

