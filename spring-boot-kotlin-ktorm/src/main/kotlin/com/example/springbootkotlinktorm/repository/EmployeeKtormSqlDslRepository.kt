package com.example.springbootkotlinktorm.repository

import com.example.springbootkotlinktorm.controller.dto.Employee
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
interface EmployeeKtormSqlDslRepository {


    fun createEmployeeViaSqlDsl(employeeSqlDsl: Employee)
}