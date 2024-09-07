package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

/*
* Singleton classes/objects in Kotlin is achieved via using "object" keyword.
* "object" in Kotlin creates only single instance of a class. Variables and functions defined inside object behaves like
* static member. Note : it behaves like static members i.e we can access them using object/class name but internally, Kotlin
* creates a single object and access these members using that object.
*
* Note : In Kotlin, there is no static modifier. It is achieved using "object" or companion object.
* */

fun main(){

    println("Default name is : " + Customer.name)

    Customer.name = "Kumar"

    println("Set name is : " + Customer.name)

    Customer.printMessage("Hello")

    Car.printMessage("Inherited Msg")
}

object Customer {

    var name: String = "Piyush" // Behind the scene static variable is created.


    fun printMessage(msg: String) { // Behind the scene accessed using singleton object.

        println("Printing message : " + msg)
    }
}

//object PriviledgedCustomer: Customer{ // We cannot inherit an singleton object to another singleton object or class
//
//}

/* But we can inherit a class to singleton object. */

open class Vehicle {

    var name: String = "Piyush"


    open fun printMessage(msg: String) {

        println("Printing message : " + msg)
    }
}

object Car : Vehicle() {

    override fun printMessage(msg: String) {
        super.printMessage(msg)

        println("Overridden printMessage")
    }
}
