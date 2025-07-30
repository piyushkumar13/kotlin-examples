package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

fun main() {

    println("============ Using object =============")
    println(MyClass.MyObject.name)
    MyClass.MyObject.name = "Kumar"
    println(MyClass.MyObject.name)
    MyClass.MyObject.writeMsg()

    /* Using companion we can access elements of object call without the nested object name as follows */

    println("============ Using companion object =============")
//    println(MyClass2.MyObject2.name) // You can still use nested object name but it will be redundant
    println(MyClass2.name) // So, you can use like this
    MyClass2.name = "Kumar"
    println(MyClass2.name)
    MyClass2.writeMsg()
}

class MyClass {

    object MyObject { // Behind the scene created as "public static final class MyObject" singleton object

        var name: String = "Piyush"  // Behind the scene created as "private static String name"

        fun writeMsg() { // Behind the scene created as "public final"
            println("Inside object writeMsg. ")

        }

    }

}

class MyClass2 {

    companion object MyObject2 { // created as public static final class

        var name: String = "Piyush" // Behind the scene created as "private static String name" at MyClass2 level

        fun writeMsg() { // Behind the scene created as "public final" within MyObject2 class
            println("Inside object writeMsg. ")
        }
    }
}