package org.example._6collections

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

fun main(){

    val list = listOf(1,2,3,12,43,32)

    val allRes = list.all ({ it > 3 })
    val anyRes = list.any({ it > 3 })
    val count = list.count ({ it > 3 })
    val findFirst = list.find ({ it > 3 })

    println("allRes : $allRes")
    println("anyRes : $anyRes")
    println("count : $count")
    println("findFirst : $findFirst")

    val myPredicate: (Int) -> Boolean = { num -> num > 3}
    val allRes1 = list.all (myPredicate)
    val anyRes1 = list.any(myPredicate)
    val count1 = list.count (myPredicate)
    val findFirst1 = list.find (myPredicate)

    println("allRes1 : $allRes1")
    println("anyRes1: $anyRes1")
    println("count1 : $count1")
    println("findFirst1 : $findFirst1")

}