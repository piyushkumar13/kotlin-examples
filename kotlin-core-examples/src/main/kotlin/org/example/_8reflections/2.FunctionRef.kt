package org.example._8reflections

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */

fun main(){

    val list1 = listOf(1,2,4,3,5,6,7)

    val result1 = list1.filter { num -> num % 2 == 0 }

    println("result1 : $result1")

    val filterExp: (Int) -> Boolean = { num -> num % 2 == 0 }
    val result2 = list1.filter(filterExp)
    println("result2 : $result2")


    fun filterFn1(value: Int): Boolean = value % 2 == 0
    val result3 = list1.filter(::filterFn1) // condition for function reference is that function which is reference should have same signature as required by lambda expression.
    println("result3 : $result3")


    val result4 = list1.filter(::filterFn2)
    println("result4 : $result4")

    /*If we are having overloaded functions, correct reference will be picked */

    fun filterFn2(value: Int): Boolean = value % 2 == 0
    fun filterFn2(value: Boolean): Boolean = value

    extraFn(::filterFn2) // it will pick up filterFn2 which receives boolean and returns boolean.

    val filterClass = FilterClass()
    val result5 = list1.filter(filterClass::filterFn3) // using class function
    println("result5 : $result5")
}

fun filterFn2(value: Int): Boolean{

    return value % 2 == 0
}

fun extraFn(predicate: (Boolean) -> Boolean) {

    println("This is to check overloaded functions passed via function reference.")

}

class FilterClass{

    fun filterFn3(value: Int): Boolean{

        return value % 2 == 0
    }

}