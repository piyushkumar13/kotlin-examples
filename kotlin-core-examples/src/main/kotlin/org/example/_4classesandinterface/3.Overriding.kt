package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

fun main(){

    println("============ Animal1 ==========")
    val animal1 = Animal1()
    println(animal1.name)
    animal1.color()

    println("============ Dog1 ==========")
    val dog1: Animal1 = Dog1()
    println(dog1.name)
    dog1.color()

    println("============ Cat1 ==========")
    val cat1: Cat1 = Cat1()
    println(cat1.name)
    cat1.color()
}

open class Animal1 {

    open val name: String = "Animal" // Val property can be overriden by val or var property but var property can only be overriden by var property.
    var type = "Mammal" // Behind the scene non-open property have final getters and setters, that's y they cannot be inherited until open.
    open var foodType = "Herbivorous"

    open fun color() {

        println("Animal Color")
    }
}

class Dog1 : Animal1() {

    override var name = "Jack"
//    override var type = "Mammal" // this will give compilation error sicne type is not open.
    override var foodType = "Carnivorous"

    override fun color() {
        println("Black")
    }
}

class Cat1 : Animal1() {

    override var name = "Sufi"
    override var foodType = "Carnivorous"

    override fun color() {
        println("White")
    }
}