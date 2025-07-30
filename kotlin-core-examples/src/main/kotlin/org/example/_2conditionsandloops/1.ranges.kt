package org.example._2conditionsandloops

/**
 * @author Piyush Kumar.
 * @since 01/09/24.
 */


fun main(){

    val range1 = 1..4 // it will contain numbers 1,2,3,4
    println("Range1 is : $range1")

    val range2 = 1..4 step 2 // it will contain numbers 2,4
    println("Range2 is : $range2")

    val range3 = 4 downTo 1 // it will contain numbers 4,3,2,1
    println("Range3 is : $range3")

    val range4 = 4 downTo 1 step 2 // it will contain numbers 4,2
    println("Range4 is : $range4")

    /* We can also have ranges for characters. */
    val range5 = 'a'..'z'
    println("Range 5 is : $range5")

    val isCharPresent = 'c' in range5
    println("C is present in range5 : $isCharPresent")

    val isNumPresent = 3 in range1
    println("3 is present in range1 : $isNumPresent")

}