package com.example.springbootkotlinktorm.domain

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

object Employees : Table<Employee>("p_employees") {

    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val company = varchar("company").bindTo { it.companyName }
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
    var department: Department?
}

interface Department : Entity<Department> {
    companion object : Entity.Factory<Department>()

    var id: Int
    var name: String
}