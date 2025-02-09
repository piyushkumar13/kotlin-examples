package org.example._4classesandinterface

/**
 * @author Piyush Kumar.
 * @since 06/09/24.
 */

fun main(){

    val student1 = Student1()
    println("Student1 name : ${student1.name}")

    val student2 = Student2("Piyush")
    println("Student2 name : ${student2.name}")

    val student3 = Student3("Piyush")
    println("Student3 name : ${student3.name}")

    val student4 = Student4("Piyush")
    println("Student4 name : ${student4.name}")

    val student4a = Student4()
    println("student4a name : ${student4a.name}")

    val student5 = Student5("Piyush", 1 )
    println("Student5 name : ${student5.name} and ${student5.id}")

    val student6 = Student6( 1 , "Piyush")
    println("Student6 name : ${student6.name} and ${student6.id}")

    val student7 = Student7( 1 , "Piyush")
    println("Student7 name : ${student7.name} and ${student7.id}")

    val student7a = Student7( 2 )
    println("Student7a id : ${student7.id} and ${student7.name}")

    val student8 = Student8( 1 , "Piyush")
    println("Student8 name : ${student8.name} and ${student8.id}")

    val student8a = Student8()
    println("Student8a name : ${student8a.name} and ${student8a.id}")

    val student9 = Student9()
    println("Student9 name : ${student9.name} and ${student9.id}")
}


/* ============================ Primary constructors and init block ================================ */

/* By default, all classes in Kotlin are public and final in nature. */

class Student1{

    val name: String

    init {
        name = "Piyush"

        println("Name : $name set in init")
    }
}

class Student2 constructor(name: String){

    val name: String

    init {
        this.name = name
        println("Set by parameterized constructor : $name")
    }
}

class Student3(name: String){

    val name: String

    init {
        this.name = name
        println("Set by parameterized constructor without using contructor keyword with constructor : $name")
    }
}

class Student4(val name: String = "Default Piyush"){

    init {
        println("Set by parameterized constructor with properties in constructor : $name")
    }
}

class Student5(val name: String, id: Int){

    val id: Int

    init {

        this.id = id
        println("Set by parameterized constructor with properties and val in constructor : $name, $id")
    }
}

/* ============================ Secondary constructors ================================ */

class Student6{

    var id: Int
    var name: String

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }
}

class Student7(val id: Int) {

    var name: String = ""

    constructor(id: Int, name: String): this(id) {
        this.name = name
    }
}

class Student8(){

    var id: Int = 1
    var name: String = ""

    constructor(id: Int, name: String): this() {
        this.id = id
        this.name = name
    }
}

class Student9(val id: Int = 1) {

    var name: String = ""

    constructor(id: Int, name: String): this(id) {
        this.name = name
    }
}