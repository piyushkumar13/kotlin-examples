package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */

/* When we want to use some keyword but that conflicts with kotlin keyword then we can use escape character to use java keyword which conflicts.*/
fun main(){

    System.`in` // since "in" is keyword in kotlin and if I want to use java System.in use backtick which is escape character.

    `in`()
}

fun `in`(){ // since "in" is keyword in kotlin and if I want to use function name as "in" then use backtick which is escape character.
    println("Using escape character.")
}