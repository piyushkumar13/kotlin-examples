package org.example._3functions

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

fun main() {


    val operand1 = 2
    val operand2 = 4

    val greaterValue1 = operand1.greaterValue(operand2) // normal function call.

    val greaterValue2 =
        operand1 greaterValueInfix operand2 // with infix function we can call like this so infix functions can only have one parameter.

    println("Greater value 1 : " + greaterValue1)
    println("Greater value 2 : " + greaterValue2)

}


fun Int.greaterValue(operand2: Int): Int {

    return if (this > operand2) {
        this
    } else {
        operand2
    }
}

infix fun Int.greaterValueInfix(operand2: Int): Int {

    return if (this > operand2) {
        this
    } else {
        operand2
    }
}