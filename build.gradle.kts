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

    /*Note that setting a toolchain via the kotlin extension updates the toolchain for Java compile tasks as well.*/
    kotlin {
        jvmToolchain(17)
    }

    /* So, this is not required as setting a toolchain via the kotlin extension updates the toolchain for Java compile tasks as well. */
//    java {
//        toolchain {
//            languageVersion.set(JavaLanguageVersion.of(17))
//        }
//    }


    /* Refer this for below config : https://kotlinlang.org/docs/gradle-configure-project.html#check-for-jvm-target-compatibility-of-related-compile-tasks
    *  However, below configuration is not required as incompatibility between kotlin and java will be avoided as we have set jvmToolchain(17) above. */
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile>().configureEach {
        jvmTargetValidationMode.set(org.jetbrains.kotlin.gradle.dsl.jvm.JvmTargetValidationMode.WARNING)
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
            dependency("org.junit.jupiter:junit-jupiter:5.9.1")
            dependency("org.jetbrains.kotlin:kotlin-test:2.0.20")
        }
    }
}


/* Following configuration is same as dependencies { testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.10") }
*  which I have specified in dependencyManagement as dependency and imported it in modules. */
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
