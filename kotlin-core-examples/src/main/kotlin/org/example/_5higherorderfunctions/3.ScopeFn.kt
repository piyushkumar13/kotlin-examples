package org.example._5higherorderfunctions

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */


fun main() {


    val person = Person()

    person.name = "Piyush"
    person.age = 34

    person.printProps()

    println("============= Use with ===========")

    with(person) { // it is just setting but not returning anything

        name = "Kumar"
        age = 32

    }

    person.printProps()

    with(person) {  // it is setting and returning this object so that methods can be called as chain.
        name = "Kumar"
        age = 30
        this
    }.printProps()

    println("============= Use apply ===========")
    /* apply is setting properties and returns this object by default so that methods can be called as chain. We dont have to explicitly return this here. */
    person.apply {
        name = "Kirad"
        age = 28
    }.printProps()


    println("============= Use also ===========")
    /* If we want to perform further actions we can use also function. */

    val mutableListOf = mutableListOf(1,2,3,4)

    val alsoList = mutableListOf.also {
        it.add(5)
        println("mutableListOf : $mutableListOf")
        it.remove(2)
        println("mutableListOf : $mutableListOf")
    }

    println("alsoList : $alsoList")

    person.also {
        it.name = "Also Name"
        it.printProps()
    }

    println("============= Use let ===========")

    val person1: Person? = null
    val person2: Person? = Person()

    person1?.let { // let executed if person1 is non-null. Usually used along with safe call operator
        println("Person1 name : ${it.name}")
        println("Person1 age : ${it.age}")
    }

    person2?.let {// let executed if person2 is non-null. Usually used along with safe call operator
        println("Person2 name : ${it.name}")
        println("Person2 age : ${it.age}")

    }


    println("============= Use run ===========")
    /* run function is the combination of with and let functions */

    person1?.run {
        println("name1 : $name")
        println("age1 : $age")
    }


    person2?.run {
        println("name2 : $name")
        println("age2 : $age")
    }

}

class Person {

    var name = ""
    var age = -1

    fun printProps() {
        println("name : $name and age : $age")
    }
}