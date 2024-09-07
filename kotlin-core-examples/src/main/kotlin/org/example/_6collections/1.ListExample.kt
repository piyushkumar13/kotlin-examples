package org.example._6collections

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

fun main(){

    println("============ Immutable list ==============")

    val listOf = listOf("piyush", "abhi", "satish")
    println("listOf : $listOf")


    println("============ Mutable list ==============")

    val mutableListOf = mutableListOf("ishwar", "pranav")
    println("mutableListOf : $mutableListOf")

    println("Printing mutableListOf")
    for (element in mutableListOf){
        print("$element ")
    }


    val arrayListOf = arrayListOf("physics", "chemistry", "maths")
    println("arrayListOf : $arrayListOf")

    println("Printing arrayListOf")
    for (index in 0..arrayListOf.size - 1){
        print("${arrayListOf[index]} ")
    }

    var arrayList = ArrayList<String>()
    arrayList.add("English")
    arrayList.add("Sanskrit")
    arrayList[0] = "Hindi"
    println("arrayList : $arrayList")

    println("Printing arrayList")
    for (index in 0..arrayList.size - 1){
        print("${arrayList.get(index)} ")
    }

}

