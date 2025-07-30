package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */


fun main(){

    println( CreditCardType.GOLD) // calls toString method which internally gets name property
    println( CreditCardType.GOLD.ordinal) // calls toString method
    println( CreditCardType.GOLD.name) // gets name property


    println( CreditCardType2.GOLD)
    println( CreditCardType2.GOLD.name)
    println( CreditCardType2.GOLD.id)
}

enum class CreditCardType {

    GOLD,
    SILVER,
    PLATINUM
}

enum class CreditCardType2(val id: String) {

    GOLD("gold"),
    SILVER("silver"),
    PLATINUM("platinum")
}


interface MyInterfaceForEnum {

    fun printMsg()
}

enum class CreditCardType3(val id: String) : MyInterfaceForEnum {

    GOLD("gold") {
        override fun printMsg() {
            println("Inside gold")
        }
    },
    SILVER("silver") {
        override fun printMsg() {
            println("Inside silver")
        }
    },
    PLATINUM("platinum") {
        override fun printMsg() {
            println("Inside platinum")
        }
    }
}

enum class CreditCardType4(val id: String) {

    GOLD("gold") {
        override fun printMsgAgain() {
            println("Inside gold")
        }
    },
    SILVER("silver") {
        override fun printMsgAgain() {
            println("Inside silver")
        }
    },
    PLATINUM("platinum") {
        override fun printMsgAgain() {
            println("Inside platinum")
        }
    };

    abstract fun printMsgAgain()
}