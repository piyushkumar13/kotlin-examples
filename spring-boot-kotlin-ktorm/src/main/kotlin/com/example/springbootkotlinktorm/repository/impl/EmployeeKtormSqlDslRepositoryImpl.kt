package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.domain.Employee
import com.example.springbootkotlinktorm.domain.Employees
import com.example.springbootkotlinktorm.repository.EmployeeKtormEntityRepository
import com.example.springbootkotlinktorm.repository.EmployeeKtormSqlDslRepository
import org.ktorm.database.Database
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
class EmployeeKtormSqlDslRepositoryImpl: EmployeeKtormSqlDslRepository {

    private lateinit var database: Database

    override fun createEmployeeViaSqlDsl(employeeSqlDsl: Employees) {
        TODO("Not yet implemented")
    }


}