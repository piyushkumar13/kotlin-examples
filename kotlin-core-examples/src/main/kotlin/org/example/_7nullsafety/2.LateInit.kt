package org.example._7nullsafety

/**
 * @author Piyush Kumar.
 * @since 08/09/24.
 */

/* Lateinit basically marks the variable that whenever it is being used it must be initialized first.
Though it is fine not to initialize var when it was declared.
It is a promise to the compiler that the variable will be initialized in future before its use.

Lateinit can only be used with var(it cannot be used with val).
It can only be used with non-nullable datatypes. It cannot be used with nullable datatypes like var name: String?

*/

fun main(){

    val country = Country()
    country.name = "India"

    println("Country name : ${country.name}")

}

class Country {

    lateinit var name: String
}