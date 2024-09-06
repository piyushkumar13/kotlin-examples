package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

fun main(){

    val person = Employee()

//    person.id = 1 // cant access as it is private and only accessible within the class
//    person.name = "Something" // cant access as it is protected and only accessible within the class or subclass.
    person.email = "pk@pk.com"
    person.country = "India"

    person.accessElements()
}

open class Person {

    private var id = 1
    protected var name = "default name"
    internal var email = "default email"
    public var country = "default country"
}

class Employee: Person() {

    fun accessElements(){

        // cant access id as it is private and only accessible within the class
        println("name: $name email : $email country: $country")
    }
}