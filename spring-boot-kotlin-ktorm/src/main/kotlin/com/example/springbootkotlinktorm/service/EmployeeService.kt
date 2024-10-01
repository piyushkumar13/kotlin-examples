package com.example.springbootkotlinktorm.service

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.domain.value.Emp

/**
 * @author Piyush Kumar.
 * @since 30/09/24.
 */
interface EmployeeService {

    fun createEmployeeViaJpa(employee: Employee): Employee

    fun createEmployeeViaKtormEntity(employee: Employee): Employee

    fun createEmployeeViaSqlDsl(employee: Employee): Employee

    fun createEmployeeViaSqlDslUsingKtormTransaction(employee: Employee): Employee

    fun createEmployeeViaSqlDslUsingKtormSpringTransaction(employee: Employee): Employee

    fun createEmployeeViaKtormAnnotation(employee: Employee): Employee

    fun getEmpoyeeViaKtormSqlDsl(empId: Int, deptId: Int): Emp

    fun getEmpoyeeViaKtormEntity(empId: Int, deptId: Int): com.example.springbootkotlinktorm.domain.Employee

}