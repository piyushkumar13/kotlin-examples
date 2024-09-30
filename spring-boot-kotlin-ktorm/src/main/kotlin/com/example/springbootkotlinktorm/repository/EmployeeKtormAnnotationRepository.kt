package com.example.springbootkotlinktorm.repository

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.domain.EmployeeAnnotated
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RestController

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
interface EmployeeKtormAnnotationRepository {

    fun createEmployee(employee: EmployeeAnnotated)
}