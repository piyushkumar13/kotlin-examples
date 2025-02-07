package org.example._1basics

/**
 * @author Piyush Kumar.
 * @since 08/09/24.
 */

fun main(){

    val human = Human()

    println("Access age : ${human.age}")
    println("Access name : ${human.name}")

//    human.age = 20 // can't do this as age setter is private.
//    human.name = "Kumar" // can't do this as name setter is private.

}

class Human {

    /*
     * Whenever we declare a property, compiler creates a private field and its respective getters and setters.
     * And the access modifiers of the getters and setters generated would be same as that of access modifier of the property by default.
     *
     * This can be proved by - as we know if property is declared as private then it can be set and get within the class, means the getters and setters
     * generated behind the scene should be private only so that getting and setting of property could be restricted within the class itself. Same can be
     * verified by checking decompiled code.
     *
     * if property is declared as public then its getters and setters would also be public. Since public property can be set and get from anywhere,
     * means the getters and setters generated behind the scene should be public only so that getting and setting of property could be done
     * from anywhere. Same can be verified by checking decompiled code.
     *  */



    // Since property is public. This property will generate a private field and getters and setters whose
    // modifier will be same as that of property by default which is public here. But, this behaviour can be changed as follows
    var age = 20 // This is the property also called as backing property
        get() { // getter will have same modifier as that of property by default which is public here.
            println("Inside getter")
            return field // Refers to backing field
        }
        private set(value) { // now generated setter will be private
            println("Inside setter")
            field = value
        }

    /* Another way of writing */
    private var _name = "Piyush" // This refers to backing field
    public var name: String
        get() {
            println("Inside getter of name property")
            return _name
        }
        private set(value) {
            println("Inside setter of name property")
            _name = value
        }
}