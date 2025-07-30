package com.example.springbootkotlinktorm.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import org.springframework.context.annotation.Configuration

/**
 * @author Piyush Kumar.
 * @since 01/10/24.
 */

//@EnableConfigurationProperties(DbConfigProperties1::class) // If we are providing EnbleConfigurationProperties here, then we also need to create its bean in configuration class file.
@ConfigurationProperties(prefix = "spring.datasource")
class DbConfigProperties1 (
    var url: String,
    var username: String
)

//@EnableConfigurationProperties(DbConfigProperties2::class)
@ConfigurationProperties(prefix = "spring.datasource")
class DbConfigProperties2(
    val url: String,
    val username: String
)

//@EnableConfigurationProperties(DbConfigProperties3::class)
@ConfigurationProperties(prefix = "spring.datasource")
data class DbConfigProperties3 @ConstructorBinding constructor(
    var url: String,
    var username: String
)

//@EnableConfigurationProperties(DbConfigProperties4::class)
@ConfigurationProperties(prefix = "spring.datasource")
data class DbConfigProperties4 @ConstructorBinding constructor(
    val url: String,
    val username: String
)

@ConfigurationProperties(prefix = "spring.datasource")
class DbConfigProperties5 (
    val url: String,
    val username: String
)