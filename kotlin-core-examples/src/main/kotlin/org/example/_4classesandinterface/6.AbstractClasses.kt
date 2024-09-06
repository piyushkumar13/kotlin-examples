package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

fun main() {

    val rectangle = Rectangle()
    rectangle.length = 10
    rectangle.breadth = 20
    val area = rectangle.area()
    println("Rectangle area : $area")

    val rectangle2 = Rectangle2(0, 0)
    rectangle2.length = 2
    rectangle2.breadth = 3
    val area2 = rectangle2.area()
    println("Rectangle2 area : $area2")
}

abstract class Shape {

    var length = 0
    var breadth = 0

    abstract fun area(): Int
}

class Rectangle : Shape() {

    //    override var length = 10; // We cannot override length(or breadth) as they are by default final.
    override fun area(): Int {
        println("length : $length breadth : $breadth")

        return length * breadth
    }

}

abstract class Shape2 { // abstract will by default be open. No need to explicitly open it.

    abstract var length: Int // abstract will by default be open. No need to explicitly open it.
    abstract var breadth: Int // abstract will by default be open. No need to explicitly open it.

    var radius: Int = 10

    constructor(radius: Int){
        this.radius = radius
    }

    abstract fun area(): Int // abstract will by default be open. No need to explicitly open it.
}

class Rectangle2 : Shape2 {

    override var length: Int
    override var breadth: Int

    constructor(length: Int, breadth: Int) : super(length) {

        this.length = length
        this.breadth = breadth
    }

    override fun area(): Int {
        println("length : $length breadth : $breadth")

        return length * breadth
    }
}