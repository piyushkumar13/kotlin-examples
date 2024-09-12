package org.example._8reflections

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */


fun main(){

    val ref = Apples::class // this gets the reference to Apples class. It will get kotlin class reference which is not same as java class reference.

    val javaRef = ref.java // this gets the java class reference.

    println("Kotlin class : $ref and Java class : $javaRef") // though output of $ref and $javaRef will look same but one is kotlin class reference and one is java class reference.
}

class Apples{

    fun doctorMsg(){
        println("Apple a day keeps doctor away.")
    }

}