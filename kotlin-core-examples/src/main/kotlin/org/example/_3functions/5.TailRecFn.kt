package org.example._3functions

import java.math.BigInteger

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

fun main(){


//    val findFiboNumber1 = findFiboNumber(100000, BigInteger("1"), BigInteger("0")) // This will give stack overflow error.
//    println("findFiboNumber1 : $findFiboNumber1")

    val findFiboNumber2 = findFiboNumberWithTailRec(100000, BigInteger("1"), BigInteger("0")) // This will not give stack overflow error.
    println("findFiboNumber2 : $findFiboNumber2")

}


fun findFiboNumber(n: Int, a: BigInteger, b: BigInteger): BigInteger{

    if (n == 0){
        return b
    }
    else {
        return findFiboNumber(n-1, a + b, a)
    }
}

tailrec fun findFiboNumberWithTailRec(n: Int, a: BigInteger, b: BigInteger): BigInteger{

    if (n == 0){
        return b
    }
    else {
        return findFiboNumberWithTailRec(n-1, a + b, a)
    }
}