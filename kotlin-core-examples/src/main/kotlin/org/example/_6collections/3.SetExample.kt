package org.example._6collections

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

fun main(){

    println("============ Immutable Set ==============")

    val setOf = setOf("piyush", "abhi", "satish", "piyush")
    println("setOf : $setOf")


    println("============ Mutable set ==============")

    val mutableSetOf = mutableSetOf("ishwar", "pranav", "pranav")
    println("mutableSetOf : $mutableSetOf")

    println("Printing mutableSetOf")
    for (element in mutableSetOf){
        print("$element ")
    }


    val hashSetOf = hashSetOf("physics", "chemistry", "maths", "chemistry")
    println("hashSetOf : $hashSetOf")

    var hashSet = HashSet<String>()
    hashSet.add("English")
    hashSet.add("Sanskrit")
    hashSet.add("Hindi")
    println("hashSet : $hashSet")

    println("Printing hashSet : ${hashSet}")

}

