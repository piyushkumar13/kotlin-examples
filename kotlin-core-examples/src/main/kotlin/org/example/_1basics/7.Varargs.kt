package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */
fun main(){

    printVarargs(4,2,1)

    val values = listOf(1, 2, 5,)
    printVarargs(*values.toIntArray()) // https://stackoverflow.com/a/45855062
    printVarargs(*arrayOf(1,2,3,4).toIntArray())
    printVarargs(*intArrayOf(1,6,2,6,2))


}

fun printVarargs(vararg values: Int){

    for (value in values){
        print("value : $value ")
    }
}