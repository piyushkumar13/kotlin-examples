package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.domain.Departments
import com.example.springbootkotlinktorm.domain.Employees
import com.example.springbootkotlinktorm.repository.EmployeeKtormSqlDslRepository
import org.ktorm.database.Database
import org.ktorm.dsl.insert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
// Following is an old way of autoriwing in kotlin. It was used prior to spring 4.3. Now we dont need to explicilty give @Autowired constructor
class EmployeeKtormSqlDslRepositoryImpl @Autowired constructor(val database: Database) : EmployeeKtormSqlDslRepository {


    override fun createEmployeeViaSqlDsl(employeeSqlDsl: Employee) {

        database.insert(Departments) {
            set(it.id, employeeSqlDsl.department.id)
            set(it.name, employeeSqlDsl.department.name)
        }

        database.insert(Employees) {
            set(it.id, employeeSqlDsl.id)
            set(it.name, employeeSqlDsl.name)
            set(it.company, employeeSqlDsl.companyName)
            set(it.departmentId, employeeSqlDsl.department.id)
        }



        println("Record inserted successfully via sql dsl")
    }
}