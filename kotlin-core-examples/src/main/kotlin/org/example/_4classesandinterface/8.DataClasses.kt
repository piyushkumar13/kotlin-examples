package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 07/09/24.
 */

fun main() {

    val user1 = User("Piyush", "Kumar")
    val user2 = User("Piyush", "Kumar")

    /* Since User object is data object, it overrides equals(), toString(), hashcode() methods. */

    println("User1 : $user1")
    println("User2 : $user2")

    if (user1 == user2) {
        println("Objects are equal.")
    } else {
        println("Objects are not equal.")
    }

    val (firstName, lastName) = User("Ab", "Kumar") // here, we have destructured the data object.
    println("Destructured firstName : $firstName")
    println("Destructured lastName : $lastName")
}

data class User(var firstName: String, val lastName: String)