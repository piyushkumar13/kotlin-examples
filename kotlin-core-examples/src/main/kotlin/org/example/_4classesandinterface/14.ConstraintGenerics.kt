package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */

fun main() {

    /* Since generic type parameter is always a subtype of Any and Nullable, so we can pass following values. */
    display(null)
    display("ABC")
    display(1)
    display(Unit)

    /*But if we want to constraint the value to some specific super type, we can use constraint generics. */

//    display2(null) // will not compile as not a subtype of Mammal constraint
//    display2("ABC") // will not compile as not a subtype of Mammal constraint
//    display2(1) // will not compile as not a subtype of Mammal constraint
//    display2(Unit) // will not compile as not a subtype of Mammal constraint

    display2(Human1) // this works since Human is the implementation of Mammal.

    display3(Human2)
}


fun <T> display(item: T) { //

    println("The item on display is : $item")
}

fun <T : Mammal> display2(item: T) {

    println("The item on display2 is : $item")
}

fun <T> display3(item: T)
        where T : Mammal, T : Vertibrate { // Here we are constraining the type which should be implementation of both Mammal and Vertibrate.
    println("The item on display3 is : $item")
}

interface Mammal {

    fun lifespan(): Int
    fun type(): String
}

interface Vertibrate {

    fun hasBackbone(): Boolean
}

object Human1 : Mammal {
    override fun lifespan(): Int {
        TODO("Not yet implemented")
    }

    override fun type(): String {
        TODO("Not yet implemented")
    }

}

object Human2 : Mammal, Vertibrate {
    override fun lifespan(): Int {
        TODO("Not yet implemented")
    }

    override fun type(): String {
        TODO("Not yet implemented")
    }

    override fun hasBackbone(): Boolean {
        TODO("Not yet implemented")
    }

}