package com.example.springbootkotlinktorm.domain

import jakarta.persistence.*
import java.time.LocalDate

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Entity
@Table(name = "p_employees")
data class EmployeeJPAEntity(

    @Id
    private var id: Int,
    private var name: String,
    private var salary: Double?,
    private var company: String,
    private var job: String?,
    private var hireDate: LocalDate?,
    private var managerId: String?,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "department_id")
    private var department: DepartmentJPAEntity
)

@Entity
@Table(name = "p_departments")
data class DepartmentJPAEntity(

    @Id
    private var id: Int,

    @Column(name = "department_name")
    private var name: String
)