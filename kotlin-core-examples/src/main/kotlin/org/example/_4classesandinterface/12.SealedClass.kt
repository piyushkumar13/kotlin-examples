package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */


/* Sealed classes are similar to enums but with a difference that enum constants has to pass the value(hardcoded value) of properties wherease
* In sealed classes we can pass the dynamic values.
*
* Few points about sealed classes :
*
* The subclasses of sealed class must be defined in the same file/or same package where sealed class is declared.
* Subclasses can be regular class, data class, object class, or even another sealed class or sealed interface.
* Sealed class ensures type-safety by restricting set of types at compile time only.
* A sealed class is implicitly abstract whose object cannot be created.
* By default, the constructor of sealed class is private, and we cannot make it as non-private.
*
* */
sealed class Shapes{

    class DefaultRectangle(): Shapes() {

    }
    class Rectangle(val length: Int, val breadth: Int): Shapes()
    data class Triangle(val r: Int): Shapes()
    object Circle: Shapes()

//    sealed class Cone: Shapes()
//    sealed interface Draw

//    abstract fun printMsg()
}

class Line(val length: Int): Shapes()

fun main(){

    val defaultRectangle = Shapes.DefaultRectangle()
    val rectangle = Shapes.Rectangle(12, 23)
    val traingle = Shapes.Triangle(12)
    val circle = Shapes.Circle
    val line = Line(2)

    checkShape(circle)
    checkShape(line)
}

fun checkShape(shape: Shapes){

    when(shape) {

        is Shapes.DefaultRectangle -> {
            println("Its a default rectangle.")
        }

        is Shapes.Rectangle -> {
            println("Its a rectangle.")
        }

        is Shapes.Triangle -> {
            println("Its a triangle.")
        }

        is Shapes.Circle -> {
            println("Its a circle.")
        }
        is Line -> {
            println("Its a line")
        }

        else -> {
            println("No shape.")
        }
    }
}