package com.example.springbootkotlinktorm.controller

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.service.EmployeeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */
@RestController
class EmployeeController {

    private lateinit var employeeService: EmployeeService

    @PostMapping("/employees/jpa")
    fun createEmployeeViaJpa(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaJpa(employee)
    }

    @PostMapping("/employees/ktorm")
    fun createEmployeeViaKtorm(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaKtormEntity(employee)
    }

    @PostMapping("/employees/ktorm-annotation")
    fun createEmployeeViaKtormAnnotation(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaKtormAnnotation(employee)
    }
}