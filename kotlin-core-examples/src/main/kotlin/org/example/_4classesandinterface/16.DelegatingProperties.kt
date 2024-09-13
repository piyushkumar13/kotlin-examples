package org.example._4classesandinterface

import kotlin.reflect.KProperty

/**
 * @author Piyush Kumar.
 * @since 13/09/24.
 */


class Car2 {

    /*If you notice in below two properties, setters definition is having same code. So, its redundant in both two properties.
    * And it will be tedious and error-prone if we need to change something in implementation which has to be changed for all properties.*/
    var name: String? = null
        set(value) {
            println("Setting the value $value")

            if (!(value?.contains("-Electric"))!!) {
                field = value + "-Electric"
            }
        }
    var model: String? = null
        set(value) {
            println("Setting the value $value")

            if (!(value?.contains("-Electric"))!!) {
                field = value + "-Electric"
            }
        }
}

/* To resolve above problem, properties delegation helps. */
class Car3 {

    var name: String? by Delegator()
    var model: String? by Delegator()
}

class Delegator {

    var formattedStr: String? = null

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String?) {

        println("thisRef: $thisRef")
        println("prop: $prop")
        println("value: $value")

        formattedStr = value
    }

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String? {
        println("Getting value")

        return formattedStr

    }
}

fun main(){
    val car2 = Car2()

    car2.name = "Car2"
    println("car2 name : ${car2.name}")

    car2.model = "Car2 model"
    println("car2 model : ${car2.model}")

    val car3 = Car3()

    car3.name = "Car3"
    println("car3 name : ${car3.name}")

    car3.model = "Car3 model"
    println("car3 model : ${car3.model}")
}