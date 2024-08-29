plugins {
    kotlin("jvm") version "2.0.20"
    application
    id("io.spring.dependency-management") version "1.1.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    version = "1.0-SNAPSHOT"

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    kotlin {
        jvmToolchain(17)
    }

    repositories {
        mavenCentral()
    }

    tasks.test{
        useJUnitPlatform()
    }

    dependencyManagement{
        
        dependencies {
            dependency("org.apache.commons:commons-lang3:3.14.0")
            dependency ("org.junit:j    unit-bom:5.9.1")
            dependency("org.junit.jupiter:junit-jupiter:5.9.1")
        }
    }
}



//dependencies {
//    testImplementation(kotlin("test"))
//}

val myTask1 = task("myTask1") {

    group = "My Custom Tasks"
    description = "MyTask1"
    doFirst {
        println("This is myTask1 doFirst1")
    }

    doLast {
        println("This is myTask1 doLast1")
    }

}

myTask1.doFirst{
    println("This is myTask1 doFirst2")

}

myTask1.doLast{
    println("This is myTask1 doLast2")

}

tasks {
    val myTask2 by registering {

        group = "My Custom Tasks"
        description = "MyTask2"

        doFirst {
            println("This is myTask2 doFirst1")
        }

        doLast {
            println("This is myTask2 doLast1")
        }
    }
}


val myTask3Provider = tasks.register("myTask3") {

    group = "My Custom Tasks"
    description = "MyTask3"

    doFirst {
        println("This is myTask3 doFirst1")
    }

    doLast {
        println("This is myTask3 doLast1")
    }
}

val myTask3 = myTask3Provider.get();

myTask3.doFirst{
    println("This is myTask3 doFirst2")

}
myTask3.doLast{
    println("This is myTask3 doLast2")
}

tasks.named("myTask3"){

    group = "My Custom Tasks"
    description = "MyTask3"

    doFirst{
        println("This is myTask3 doFirst3")
    }

    doLast{
        println("This is myTask3 doLast3")
    }
}

val myTask4 = tasks.create("myTask4") {

    group = "My Custom Tasks"
    description = "MyTask4"

    doFirst {
        println("This is myTask4 doFirst1")
    }

    doLast {
        println("This is myTask4 doLast1")
    }
}

myTask4.doFirst{
    println("This is myTask4 doFirst2")

}

myTask4.doLast{
    println("This is myTask4 doLast1")
}
