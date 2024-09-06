package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */


fun main(){

    val interfaceImpl = InterfaceImpl()

    interfaceImpl.printInterfaceName1()
    interfaceImpl.printInterfaceName2()
    interfaceImpl.sayHello()
    interfaceImpl.message()
}


interface MyInterface1 {

    val name: String

    fun printInterfaceName1(){
        println("Inside MyInterface1")
    }

    fun sayHello(){
        println("Hello from MyInterface1")
    }

    fun message()
}

interface MyInterface2 {

    val type: String

    fun printInterfaceName2(){
        println("Inside MyInterface1")
    }

    fun sayHello(){
        println("Hello from MyInterface2")
    }

    fun message()
}

class InterfaceImpl : MyInterface1, MyInterface2{

    override val name: String = "Kotlin"
    override val type: String = "Programming"

    override fun sayHello() {
        super<MyInterface1>.sayHello()
        super<MyInterface2>.sayHello()
    }

    override fun message() {
        println("Msg from InterfaceImpl")
    }
}

