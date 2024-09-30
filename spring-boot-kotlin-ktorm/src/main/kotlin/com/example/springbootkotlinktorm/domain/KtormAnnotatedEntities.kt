package com.example.springbootkotlinktorm.domain

import org.ktorm.entity.Entity
import org.ktorm.ksp.annotation.PrimaryKey
import org.ktorm.ksp.annotation.References
import org.ktorm.ksp.annotation.Table

/**
 * @author Piyush Kumar.
 * @since 30/09/24.
 */

@Table("p_employees")
interface EmployeeAnnotated : Entity<EmployeeAnnotated> {

    @PrimaryKey
    var id: Int
    var name: String
    var companyName: String

    @References
    var department: DepartmentAnnotated
}

@Table("p_departments")
interface DepartmentAnnotated : Entity<DepartmentAnnotated> {

    @PrimaryKey
    var id: Int
    var name: String
}