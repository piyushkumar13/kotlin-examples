package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.domain.Department
import com.example.springbootkotlinktorm.domain.Departments
import com.example.springbootkotlinktorm.domain.Employee
import com.example.springbootkotlinktorm.domain.Employees
import com.example.springbootkotlinktorm.repository.EmployeeKtormEntityRepository
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
import org.springframework.stereotype.Repository

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
class EmployeeKtormEntityRepositoryImpl(private var database: Database): EmployeeKtormEntityRepository {

    override fun createEmployeeViaEntity(employee: Employee, department: Department) {

        val sequenceOfDept = database.sequenceOf(Departments)
        val add = sequenceOfDept.add(department)

        println("Department id : $add") // it returns no of records added

        employee.department = sequenceOfDept.find { it.id eq department.id }

        database.sequenceOf(Employees)
            .add(employee)

    }
}