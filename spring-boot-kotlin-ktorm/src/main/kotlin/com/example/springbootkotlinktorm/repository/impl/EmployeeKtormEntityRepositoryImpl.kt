package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.domain.Employee
import com.example.springbootkotlinktorm.repository.EmployeeKtormEntityRepository
import org.ktorm.database.Database
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
class EmployeeKtormEntityRepositoryImpl: EmployeeKtormEntityRepository {

    private lateinit var database: Database

    override fun createEmployeeViaEntity(employee: Employee) {
        TODO("Not yet implemented")
    }
}