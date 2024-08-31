package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 31/08/24.
 */

fun main() {

    /* ======================== Create array using Array() constructor  ===========================*/

    val myArr = Array<Int>(4) { 0 } // Array type is inferred as Array<Int>
    println("Array size is ${myArr.size}")
    println("Array initialized with all elements with 0 ${myArr}")

    println("Printing elements of the array :::: ")
    for (element in myArr) {
        print(element)
    }

    myArr[0] = 4
    myArr[1] = 5

    println("\nPrinting elements of the array after providing values :::: ")
    for (element in myArr) {
        print(element)
    }

    println("\nPrinting elements of the array after providing values using index :::: ")
    for (index in 0..myArr.size - 1) {
        print(myArr[index])
    }

    /* ======================== Create array using arrayOf()  ===========================*/

    val myArr1 = arrayOf(1, 3, 5, 2) // Array type is inferred as Array<Int>

    println("Printing elements of myArr1")

    for (element in myArr1) {
        print(element)
    }

    println("\n print whole array, myArr1=" + myArr1.joinToString())

    /* ======================== Create array using arrayOfNulls()  ===========================*/

    val myArr2 = arrayOfNulls<Int>(3) // Array type is inferred as Array<Int?>

    println("Printing array of nulls : ${myArr2.joinToString()}")


    /* ======================== Create array using emptyArray()  ===========================*/

    val myArr3 = emptyArray<String>() // Array type is inferred as Array<String>

    println("Printing empty array : [${myArr3.joinToString()}]")

    /* ======================== Create array using Array() constructor and use lamda to initialize values ===========*/

    val myArr4 = Array<Int>(3) { index -> index + 2 }
    println("Printing myArr4 : ${myArr4.joinToString()}")

    /* ========================== Nested Array ======================== */

    val myArr5 = Array(2) { Array<Int>(4) { 0 } } // Array type is inferred as Array<Array<Int>>

    println("Printing myArr5 row 1 : {${myArr5[0].joinToString()}}")
    println("Printing myArr5 row 2 : {${myArr5[1].joinToString()}}")

    /* ======================= Compare arrays ========================== */

    val myArr6 = arrayOf(3, 4, 5)
    val myArr7 = arrayOf(3, 4, 5)

    println("Is myArr6 equals to myArr7 : ${myArr6.contentEquals(myArr7)}") // content equals also check the order while comparing.

    println("Is myArr6 equals to myArr7 using infix : ${myArr6 contentEquals myArr7 }") // using infix function.


    /* ======================= Transform arrays ========================== */

    val myArr8 = arrayOf(3, 4, 5)

    println("Sum of elements of array is : " + myArr8.sum())

    myArr8.shuffle()

    println("Shuffled array is : "+ myArr8.joinToString())


    /* ====================== Convert to collections ===================== */

    val myArr9 = arrayOf(5,2,1)
    val toList = myArr9.toList()
    println("Converting myArr9 to list : " + toList)

    val myArr10 = arrayOf(7,4,3)
    val toSet = myArr10.toSet()
    println("Converting myArr10 to set : " + toSet)

    /* Only an array of Pair<K,V> can be converted to a Map. The first value of a Pair instance becomes a key, and the second becomes a value. */

    val myArr11 = arrayOf("maths" to 95, "Science" to 94)
    val toMap = myArr11.toMap()
    println("Converting myArr11 to map : " + toMap)
}