package org.example._2conditionsandloops

/**
 * @author Piyush Kumar.
 * @since 02/09/24.
 */

fun main() {

    println("==================== Break Statement ===================== ")

    for (i in 1..3) {
        for (j in 1..3) {

            if (i == 2 && j == 2) {
                break
            }

            println("i : $i and j: $j")
        }
    }

    /* Labelled break statement. */

    println("==================== Labelled Break Statement ===================== ")
    myLoop@ for(i in 1..3){
        for (j in 1..3){

            if (i == 2 && j == 2){
                break@myLoop
            }

            println("i : $i and j : $j")
        }
    }

    println("==================== Continue Statement ===================== ")

    for (i in 1..3) {
        for (j in 1..3) {

            if (i == 2 && j == 2) {
                continue
            }

            println("i : $i and j: $j")
        }
    }

    /* Labelled Continue statement. */

    println("==================== Labelled Continue Statement ===================== ")
    myContinue@ for(i in 1..3){
        for (j in 1..3){

            if (i == 2 && j == 2){
                continue@myContinue
            }

            println("i : $i and j : $j")
        }
    }
}