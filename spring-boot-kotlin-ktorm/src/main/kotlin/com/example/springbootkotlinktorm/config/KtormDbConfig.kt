package com.example.springbootkotlinktorm.config

import org.ktorm.database.Database
import org.ktorm.support.postgresql.PostgreSqlDialect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Piyush Kumar.
 * @since 30/09/24.
 */

@Configuration
class KtormDbConfig {

    @Bean
    fun ktormDb(): Database {

        return Database.connect(
            url = "jdbc:postgresql://localhost:5432/pikumar?currentSchema=public",
            driver = "org.postgresql.Driver",
            user = "postgres",
            dialect = PostgreSqlDialect()
        )
    }
}