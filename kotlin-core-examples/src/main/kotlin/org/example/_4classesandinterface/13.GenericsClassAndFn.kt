package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */


fun main(){

    val intContainer1 = Container<Int>(3)
    val intContainer2 = Container(2) // here it will automatically infer the generic type.

    val strContainer1 = Container<String>("Hello")
    val strContainer2 = Container("Hello 2") // here it will automatically infer the generic type.

    intContainer1.getValue();
    strContainer2.getValue()


}

class Container<T>(var data: T){

    fun setValue(myValue: T){

        println("myValue : $myValue")

        data = myValue

    }

    fun getValue(): T{
        println("myValue : $data")

        return data
    }
}

/*============== Generic functions =============== */

class Messenger2 {

    fun<T> consume(value: T) { // This is a generic function.

        println("The value in message2 : $value")
    }

}

fun<T> sayHello(msg: T){
    println("Saying hello : $msg")
}
