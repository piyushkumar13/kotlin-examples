package org.example._2conditionsandloops

/**
 * @author Piyush Kumar.
 * @since 01/09/24.
 */


fun main(){

    /* Conventional way of for loop does not exists in Kotlin*/
    //    for ( var a: Int = 0; a < 3; a++){
    //
    //    }

    /* For loops in Kotlin */
    for (i in 1..3){
        println("The value of i in loop1 is : $i")
    }

    for (i in 1..5 step 2){
        println("The value of i in loop2 is : $i")
    }

    for (i in 3 downTo 1){
        println("The value of i in loop3 is : $i")
    }

    for (i in 5 downTo 1 step 2){
        println("The value of i in loop3 is : $i")
    }


    val myArr = arrayOf(6,2,3,3)
    for (element in myArr){
        println("Element in myArr is : $element")
    }

    for ( (index, element) in myArr.withIndex()){
        println("The index is $index and element is $element")
    }

    for(index in myArr.indices){
        println("Accessing element in myArr with index : ${myArr[index]}")
    }

    /* While and do-while loop are same conventional way of java in Kotlin as well. */

    var i: Int = 0

    while (i < 3){
        println("I in while loop is : $i")
        i++
    }

    var j: Int = 0
    do {
        println("I in do-while loop is : $j")
        j++
    }while (j < 3)

}