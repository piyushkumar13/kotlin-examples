package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 13/09/24.
 */

class A {
    inner class MyInnerForA
}
class B {
    inner class MyInnerForB
}


typealias MyList = List<Int>
typealias MyIntPredicate = (Int) -> Boolean
typealias MyGenericPredicate<T> = (T) -> Boolean
typealias InnerA = A.MyInnerForA
typealias InnerB = B.MyInnerForB

fun main() {

    val list1: MyList = listOf(1,2,4,2,12,3)

    val myPredicate: MyIntPredicate = { num -> num >= 4}
    val myGenPredForString: MyGenericPredicate<String> = {str -> str.isNotEmpty() }

}