package org.example._8reflections

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */


fun main(){

    testConstructorRef(::ABC) // condition for constructor reference is that constructor which is reference should have same signature as required by lambda expression.
}

fun testConstructorRef(param: (Int) -> Unit){
    println("Using constructor reference for param")
}

class ABC(val name: Int) {

    fun printName(){
        println("name : $name")
    }
}

