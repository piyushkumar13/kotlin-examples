package com.example.springbootkotlinktorm.repository

import com.example.springbootkotlinktorm.domain.Employee
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
interface EmployeeKtormEntityRepository {

    fun createEmployeeViaEntity(employeeKtormEntity: Employee)
}