package com.example.springbootkotlinktorm

import com.example.springbootkotlinktorm.config.DbConfigProperties5
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableConfigurationProperties(DbConfigProperties5::class)
@ConfigurationPropertiesScan // We can use this it will scan all the configuration properties falling within the child packages.
class SpringBootKotlinKtormApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinKtormApplication>(*args)

    /* We can also use following two ways to start spring boot application which is similar to what we do in java. */
//    SpringApplication.run(SpringBootKotlinKtormApplication::class.java, *args)
//    SpringApplication.run(arrayOf(SpringBootKotlinKtormApplication::class.java), args)
}
