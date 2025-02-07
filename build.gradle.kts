plugins {
    kotlin("jvm") version "2.0.20"
    application
    kotlin("plugin.spring") version "1.9.25" apply false
    id("org.springframework.boot") version "3.3.4" apply false
    kotlin("plugin.jpa") version "1.8.0" apply false
    id("io.spring.dependency-management") version "1.1.6"
    id("com.google.devtools.ksp") version "2.0.20-1.0.24" apply false
}


/* How to access properties in build.gradle.kts https://stackoverflow.com/a/73573014 */
val springBootVersion : String by project
println("springBootVersion : $springBootVersion")

val springBootVersionByProvider = providers.gradleProperty("springBootVersion")
println("springBootVersionByProvider : $springBootVersion")

val ktormVersion: String = project.findProperty("ktorm.version") as String
println("ktormVersion : ${ktormVersion}")

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    println("The subproject is ::: ${this.name}")

    if (this.name == "spring-boot-kotlin-ktorm"){

        println("Applying to module : spring-boot-kotlin-ktorm")

        apply(plugin = "org.springframework.boot")
        apply(plugin = "org.jetbrains.kotlin.plugin.spring")
        apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
        apply(plugin = "com.google.devtools.ksp")
    }

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
            dependency("org.ktorm:ktorm-core:${ktormVersion}")
            dependency("org.ktorm:ktorm-support-postgresql:${ktormVersion}")
            dependency("org.ktorm:ktorm-ksp-annotations:${ktormVersion}")
            dependency("org.ktorm:ktorm-ksp-compiler:${ktormVersion}")
            dependency("org.postgresql:postgresql:42.7.4")
            dependency("net.datafaker:datafaker:2.4.2")
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
