package org.example._3functions

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */


/*
* By using extension functions, we can add any new functions to the existing classes without modifying class definition.
* It is useful if we want to add functions to third party classes.
* */


fun main() {

    val str1 = "Hello "
    val str2 = "World "
    val str3 = "Piyush"

    val concatStr = str1.myConcatination(str2, str3)

    println(concatStr)

}


fun String.myConcatination(str2: String, str3: String): String { // Here, myConcatination is added to existing String class

    return this + str2 + str3;
}