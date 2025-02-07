package com.example.springbootkotlinktorm.config

import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.ktorm.support.postgresql.PostgreSqlDialect
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Piyush Kumar.
 * @since 30/09/24.
 */

@Configuration
class KtormDbConfig(
    val dbConfigProps1: DbConfigProperties1,
    val dbConfigProps2: DbConfigProperties2,
    val dbConfigProps3: DbConfigProperties3,
    val dbConfigProps4: DbConfigProperties4,
    val dbConfigProps5: DbConfigProperties5
) {

    @Value("\${spring.datasource.url}")
    lateinit var url: String

    @Bean
    fun ktormDb(): Database {

        println("The property value using @Value is : $url")

        return Database.connect(
            url = dbConfigProps1.url,
            driver = "org.postgresql.Driver",
            user = dbConfigProps1.username,
            dialect = PostgreSqlDialect(),
            logger = ConsoleLogger(LogLevel.DEBUG)
        )
    }
}