package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

/* By default, all classes in Kotlin are public and final in nature. Since it is final it cannot be inherited. To make the class
* open for inheritance, we need to use open keyword with the class.
*  */


fun main() {

    println("============= Animal ===============")
    var animal = Animal()
    println(animal.name)
    animal.color()

    println("============= Dog ===============")
    var dog = Dog()
    println(dog.name)
    dog.color()
    dog.bark()

    println("============= Cat ===============")
    var cat = Cat()
    println(cat.name)
    cat.color()
    cat.meow()
}

open class Animal {

    var name: String = "Animal"

    fun color() {

        println("Animal Color")
    }
}

class Dog : Animal() {

    fun bark() {
        println("Bark")
    }
}

class Cat : Animal() {

    fun meow() {
        println("Meow")
    }
}