package org.example._6collections

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */


fun main() {

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val filteredList = list.filter { element -> element % 2 == 0 }

    println("Filtered list : $filteredList")

    val filteredList2 =
        list.filter { it % 2 == 0 } // we can also write the filter using it as filter is having only one parameter.

    println("filteredList2 : $filteredList2")

    val mappedList = list.map { element -> element * element }
    println("mappedList : $mappedList")

    val mappedList2 = list.map { it * it } // we can also write the map using it as map is having only one parameter.
    println("mappedList2 : $mappedList2")


    val reducedList = list
        .filter { it % 2 == 0 }
        .map { it * it }

    println("reducedList : $reducedList")

    val listOfPerson = listOf(
        Person(name = "Piyush", age = 34),
        Person(name = "Satish", age = 40)
    )

    val reducedPersonNames = listOfPerson
        .filter { it.age > 30 }
        .map { it.name }

    println("reducedPersonNames : $reducedPersonNames")
}


data class Person(var name: String, var age: Int)