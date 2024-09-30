package com.example.springbootkotlinktorm.controller.dto

/**
 * @author Piyush Kumar.
 * @since 30/09/24.
 */
data class Employee(
    var id: Int,
    val name: String,
    val companyName: String,
    val department: Department
)
