package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.domain.*
import com.example.springbootkotlinktorm.repository.EmployeeKtormAnnotationRepository
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
class EmployeeKtormAnnotationRepositoryImpl(private var database: Database): EmployeeKtormAnnotationRepository {

    override fun createEmployee(employee: EmployeeAnnotated, department: DepartmentAnnotated) {


        val sequenceOfDeptAnnotated = database.sequenceOf(DepartmentAnnotateds)
        val add = sequenceOfDeptAnnotated.add(department)

        println("Department id : $add") // it returns no of records added

        employee.department = sequenceOfDeptAnnotated.find { it.id eq department.id }

        database.sequenceOf(EmployeeAnnotateds)
            .add(employee)
    }

}