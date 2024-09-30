package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 13/09/24.
 */

data class Truck(var name: String, var model: String)

fun main(){

    val truck1 = Truck("Volvo", "2024")

    // destructuring object

    val (name1, model1) = truck1

    println("name1: $name1 and model1: $model1")

    // We can also destructure at the time of initializing object

    val (name2, model2) = Truck("Volvo", "2024")
    println("name2: $name2 and model2: $model2")

    // We can also partially destructure value

    val (firstVar) = truck1
    println("firstVar will be name here : $firstVar")

    // We can also ignore value while destructuring

    val (_, model3) = truck1
    println("model3: $model3")

    val myMap = mapOf(1 to "Piyush", 2 to "Kumar")

    for ((key, value) in myMap){

        print("Key : $key Value : $value")
    }

    // Destructuring in lambdas

    val mapValues = myMap.mapValues { (key, value) -> "key:$key-value:$value" }
    println("\n mapValues map : $mapValues ")

}