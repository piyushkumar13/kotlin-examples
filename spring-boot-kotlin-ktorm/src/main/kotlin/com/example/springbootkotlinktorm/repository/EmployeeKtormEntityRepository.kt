package com.example.springbootkotlinktorm.repository

import com.example.springbootkotlinktorm.domain.Department
import com.example.springbootkotlinktorm.domain.Employee
import com.example.springbootkotlinktorm.domain.value.Emp
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
interface EmployeeKtormEntityRepository {

    fun createEmployeeViaEntity(employeeKtormEntity: Employee, departmentKtormEntity: Department)

    fun getEmployeeViaKtormEntity(empId: Int, deptId: Int): Employee?
}