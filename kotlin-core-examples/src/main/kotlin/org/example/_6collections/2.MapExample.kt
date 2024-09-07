package org.example._6collections

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

fun main(){

    println("============ Immutable Map ==============")

    val mapOf = mapOf("piyush" to 1, "abhi".to(2), "satish" to 3)
    println("mapOf : ${mapOf}")


    println("============ Mutable Map ==============")

    val mutableMapOf = mutableMapOf("ishwar" to 4, "pranav" to 5)
    println("mutableListOf : $mutableMapOf")

    println("Printing mutableMapOf")
    for (entry in mutableMapOf){
        print("$entry ")
    }


    val hashMapOf = hashMapOf("physics" to 1, "chemistry" to 2, "maths" to 3)
    println("arrayListOf : $hashMapOf")

    println("Printing hashMapOf")

    println("Printing values using key")
    for (key in hashMapOf.keys){
        print("${hashMapOf[key]} ")
    }

    println("Printing values")
    for (value in hashMapOf.values){
        print("${value} ")
    }

    val hashMap = HashMap<String, Int>()
    hashMap.put("English", 4)
    hashMap.put("Sanskrit", 5)
    hashMap.put("Hindi", 6)
    println("hashMap : $hashMap")

    println("Printing hashMap using key")
    for (key in hashMap.keys){
        print("${hashMap.get(key)} ")
    }
    println("Printing hashMap entry set")
    for (entry in hashMap.entries){
        print("${entry} ")
    }

}

