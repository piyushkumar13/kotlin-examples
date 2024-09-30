package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.domain.EmployeeAnnotated
import com.example.springbootkotlinktorm.repository.EmployeeKtormAnnotationRepository
import org.ktorm.database.Database
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
class EmployeeKtormAnnotationRepositoryImpl: EmployeeKtormAnnotationRepository {

    private lateinit var database: Database

    override fun createEmployee(employee: EmployeeAnnotated) {
        TODO("Not yet implemented")
    }

}