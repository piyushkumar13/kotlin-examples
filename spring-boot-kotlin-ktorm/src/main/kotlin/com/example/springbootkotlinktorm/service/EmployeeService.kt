package com.example.springbootkotlinktorm.service

import com.example.springbootkotlinktorm.controller.dto.Employee

/**
 * @author Piyush Kumar.
 * @since 30/09/24.
 */
interface EmployeeService {

    fun createEmployeeViaJpa(employee: Employee): Employee

    fun createEmployeeViaKtormEntity(employee: Employee): Employee

    fun createEmployeeViaSqlDsl(employee: Employee): Employee

    fun createEmployeeViaKtormAnnotation(employee: Employee): Employee


}