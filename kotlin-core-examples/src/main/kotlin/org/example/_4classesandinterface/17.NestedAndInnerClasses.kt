package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 13/09/24.
 */


class Outer {

    private val name: String = "Piyush"

    // This basically decompiled to static nested clas which cannot access member of outer class without outer class object reference.
    // It needs to use outer class object to access its instance variables.
    class Inner {
        fun msg() {
            println("Inside inner class")
        }

        fun msg2() {

            val outer = Outer()
            println("Inside inner class ${outer.name}") // accessing using outer class object.
        }

    }
}

class Outer2 {

    private val name: String = "Piyush Outer 2"

    inner class Inner2 { // This basically decompiled to nested inner class which can access member of outer class without outer class object reference.

        fun msg() {
            println("Inside inner2 class $name")
        }
    }
}

interface Messeger {

    fun msg()
}

/* You can also use interfaces with nesting. All combinations of classes and interfaces are possible:
You can nest interfaces in classes, classes in interfaces, and interfaces in interfaces.*/
fun main() {

    Outer.Inner().msg()

    Outer2().Inner2().msg()


    /*============ Anonymous Inner class ============ */

    val anonymousInnerClassObj = object : Messeger {

        override fun msg() {
            println("Anonymous Inner class")
        }
    }

    anonymousInnerClassObj.msg()
}