package com.example.springbootkotlinktorm.domain

import org.ktorm.entity.Entity
import org.ktorm.ksp.annotation.Column
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

    @Column(name = "company")
    var companyName: String

    @References // by default it it will use table attribute that will be snake case of department prop and id prop of DepartmentAnnotated i.e department_id
    var department: DepartmentAnnotated?
}

@Table("p_departments")
interface DepartmentAnnotated : Entity<DepartmentAnnotated> {

    @PrimaryKey
    var id: Int

    @Column(name = "department_name")
    var name: String
}