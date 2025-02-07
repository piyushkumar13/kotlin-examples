package com.example.springbootkotlinktorm.domain

import com.example.springbootkotlinktorm.domain.Departments.bindTo
import org.ktorm.entity.Entity
import org.ktorm.schema.*
import java.time.Instant
import java.time.LocalDate

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

object Employees : Table<Employee>("p_employees") {

    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val company = varchar("company").bindTo { it.companyName }
    val salary = double("salary").bindTo { it.salary }
    val job = varchar("job").bindTo { it.job }
    val hireDate = date("hire_date").bindTo { it.hireDate }
    val managerId = varchar("manager_id").bindTo { it.managerId }
    val departmentId = int("department_id").references(Departments) { it.department }
}

object Departments : Table<Department>("p_departments") {

    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("department_name").bindTo { it.name }
}

interface Employee : Entity<Employee> {

    companion object : Entity.Factory<Employee>()

    var id: Int
    var name: String
    var companyName: String
    var salary: Double
    val job: String
    val hireDate: LocalDate
    val managerId: String
    var department: Department?
}

interface Department : Entity<Department> {
    companion object : Entity.Factory<Department>()

    var id: Int
    var name: String
}