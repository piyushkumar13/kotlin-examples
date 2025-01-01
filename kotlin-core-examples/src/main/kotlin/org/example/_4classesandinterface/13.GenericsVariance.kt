package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 12/09/24.
 */

/**
 * Sometimes, you may want to use Generics type parameter in specific context only. This is called as variance.
 * There are two ways of providing variance : Declaration-site variance and use-site variance.
 *
 * A type which is used for input as well as for output is known as invariance. Basically, type which can be produced and consumed.
 *
 * A type that can only be produced basically which represents the return is called as covariance.
 * A type that can only be consumed basically which represents the input is called as contravariant.
 */

/* A covariant type is usually represented by modifier "out" along with type parameter. */


/* =========================== Declaration-site variance==================== */

/* In the following types of generics where type parameter is used in specific context, the type-parameter type is defined at the time of declaration.
* These types of variance are called declaration-site variance. */
class Greeting1<out T>(val msg: T){ // note I have used val not var as msg cannot be set again as it is of covariance type.

    fun sayHello(): T {

        println("The message is : $msg")
        return msg
    }
}

class Greeting2<in T>{

    fun sayHello(msg: T) {

        println("The message is : $msg")
    }
}

/* =========================== use-site variance==================== */

/* In the below class, T is invariant. But, when we are making call to functions of this class, we can define what type of variance to use.
* Defining type of variance at the time of call(i.e usage) is called as use-site variance.
*/
class Messenger<T>(val t: T) {

    fun consume(value: T) {

    }

    fun produce(): T {

        return t
    }

}

fun publish(a: Messenger<out String>){ // Here variance is define at the time of usage.

    a.produce()
//    a.consume("Hello") // Here this will not be allowed, it will give compilation error as in the context generic is of covariance type i.e it can only produce(return type).
}


fun main(){

    val msg: Messenger<out Int> = Messenger(3)
    msg.produce()
//    msg.consume(2) // It will not compile as "msg" is of covariance type i.e it can only be used for producing values. Such variance type is called use-site variance.
}








