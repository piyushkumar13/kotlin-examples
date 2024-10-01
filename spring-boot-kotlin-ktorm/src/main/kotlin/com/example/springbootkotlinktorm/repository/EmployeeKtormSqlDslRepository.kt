package com.example.springbootkotlinktorm.repository

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.domain.value.Emp
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
interface EmployeeKtormSqlDslRepository {


    fun createEmployeeViaSqlDsl(employeeSqlDsl: Employee)

    fun createEmployeeViaSqlDslUsingTransaction(employeeSqlDsl: Employee)

    fun createEmployeeViaSqlDslUsingSpringTransaction(employeeSqlDsl: Employee)

    fun getEmployeeViaSqlDsl(empId: Int, deptId: Int): Emp

}