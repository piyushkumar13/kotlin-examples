package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */
fun main(){

    printVarargs(4,2,1)

    val values = listOf(1, 2, 5,)
    printVarargs(*values.toIntArray()) // https://stackoverflow.com/a/45855062

}

fun printVarargs(vararg values: Int){

    for (value in values){
        print("value : $value ")
    }
}