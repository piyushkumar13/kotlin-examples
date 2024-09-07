package org.example._5higherorderfunctions

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */


fun main() {

    val myLambdaExample = MyLambdaExample()

    /* Using anonymous class */
    myLambdaExample.addTwoNums1(1, 2, object : Addition { // creating anonymous class

        override fun add(a: Int, b: Int): Int {
            return a + b
        }
    })

    /* Using lambda expression for Functional (SAM) interface */

    val mySum = Addition { a, b -> a + b } // you can also optionally specify the type in lambda expression as Addition { a: Int, b: Int -> a + b }
    myLambdaExample.addTwoNums1(1, 2, mySum)

    /* Using lambdas */

    val addTwoNums2 = { a: Int, b: Int ->

        val sum = a + b
        println("The sum is " + sum)
        a + b

    }

    myLambdaExample.addTwoNums2(3, 4, addTwoNums2)

    val addTwoNums3: (Int, Int) -> Int = { a, b -> // You can optionally specify the type as well here as a: Int, b: Int

        val sum = a + b
        println("The sum is " + sum)
        sum

    }

    myLambdaExample.addTwoNums2(5, 6, addTwoNums3)

    myLambdaExample.addTwoNums2(7, 8, { a, b ->
        val sum = a + b
        println("The sum by passing directly lambda expression" + sum)
        sum
    })

    myLambdaExample.addTwoNums2(8, 9) { a, b ->
        val sum = a + b
        println("The sum by passing directly lambda expression with curly braces outside" + sum)
        sum
    }
}


class MyLambdaExample {

    fun addTwoNums1(a: Int, b: Int, add: Addition) {

        println("The addition is : " + add.add(a, b))
    }

    fun addTwoNums2(a: Int, b: Int, add: (Int, Int) -> Int) {

        println("The addition is : " + add(a, b))
    }

}

fun interface Addition {

    fun add(a: Int, b: Int): Int
}