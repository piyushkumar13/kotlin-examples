package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

fun main() {

    println("=========== Inheritance with primary constructor ========= ")
    val animal2 = Animal2("Sher")
    val dog2 = Dog2("Black", "Jack")

    println("=========== Inheritance with secondary constructor ========= ")
    val animal3 = Animal3("Sher")
    val dog3 = Dog3("Black","White")

}

/* ==================== Inheritance in primary constructor =============== */
open class Animal2(var name: String) {

    init {
        println("Animal2 name : $name")
    }
}

class Dog2(var color: String, dogName: String) : Animal2(dogName) {

    init {
        println("Dog2 name : $dogName and color : $color")
    }
}

/* ==================== Inheritance in secondary constructor =============== */
open class Animal3 {

    var name:String

    constructor(name: String){
        println("name : $name")
        this.name = name
    }
}

class Dog3(var color: String, dogName: String) : Animal3(dogName) {

    init {
        println("Dog2 name : $dogName and color : $color")
    }
}

open class Animal4 {

    var name:String

    constructor(name: String){
        println("name : $name")
        this.name = name
    }
}

class Dog4 : Animal3 {

    var color: String
    var dogName: String

    constructor(color: String, dogName: String): super(dogName){

        this.color = color
        this.dogName = color
    }

}

/* ==================== Inheritance with primary & secondary constructor =============== */

open class Animal5 {

    var name:String = ""

}

class Dog5() : Animal5() {

    var color: String = ""
    var dogName: String = ""
    constructor(color: String, dogName: String) : this() {
        this.color = color
        this.dogName = dogName
    }
}