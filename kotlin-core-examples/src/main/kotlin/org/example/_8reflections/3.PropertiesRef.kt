package org.example._8reflections

import kotlin.reflect.jvm.javaGetter

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */

val height = 1.23F
var age = 34
fun main(){

    val propRef = ::height

    println("PropRef : $propRef")

    // to get the property value from property reference
    println("Property Value from propRef : ${propRef.get()}")

    // Getting name of the property from property reference
    println("Name of the property from propRef : ${propRef.name}")

    // Setting a value of the property from property reference
    val agePropRef = ::age
    agePropRef.set(35)
    println("Setting value of the property from propRef : ${agePropRef.get()}")

    val classCarProperty = Car::name
    println("classCarProperty : $classCarProperty")
    println("Java getter : ${classCarProperty.javaGetter}")
}

class Car(val name: String){

    fun printType(){
        println("Name of the car : $name")
    }
}

