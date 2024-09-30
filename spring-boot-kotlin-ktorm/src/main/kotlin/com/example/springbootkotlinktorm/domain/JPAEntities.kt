package com.example.springbootkotlinktorm.domain

import jakarta.persistence.*

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
    private var company: String,

    @OneToOne(cascade = [CascadeType.ALL])
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