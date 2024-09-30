package com.example.springbootkotlinktorm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinKtormApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinKtormApplication>(*args)

    /* We can also use following two ways to start spring boot application which is similar to what we do in java. */
//    SpringApplication.run(SpringBootKotlinKtormApplication::class.java, *args)
//    SpringApplication.run(arrayOf(SpringBootKotlinKtormApplication::class.java), args)
}
