package com.example.springbootkotlinktorm.repository

import com.example.springbootkotlinktorm.domain.DepartmentJPAEntity
import com.example.springbootkotlinktorm.domain.EmployeeJPAEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.RestController

/**
 * @author Piyush Kumar.
 */
interface DepartmentJPARepository: JpaRepository<DepartmentJPAEntity, Int> {


}