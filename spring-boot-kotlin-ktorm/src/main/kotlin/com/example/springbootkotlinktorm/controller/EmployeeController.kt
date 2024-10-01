package com.example.springbootkotlinktorm.controller

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */
@RestController
class EmployeeController {

    @Autowired
    private lateinit var employeeService: EmployeeService

    @GetMapping("/test-exception")
    fun testException(){

        throw IllegalArgumentException("Testing exception")
    }


    @PostMapping("/employees/jpa")
    fun createEmployeeViaJpa(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaJpa(employee)
    }

    @PostMapping("/employees/ktorm-sql-dsl")
    fun createEmployeeViaKtormSqlDsl(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaSqlDsl(employee)
    }

    @PostMapping("/employees/ktorm-sql-dsl/ktorm-transaction")
    fun createEmployeeViaKtormSqlDslUsingKtormTransaction(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaSqlDslUsingKtormTransaction(employee)
    }

    @PostMapping("/employees/ktorm-sql-dsl/ktorm-spring-transaction")
    fun createEmployeeViaKtormSqlDslUsingKtormSpringTransaction(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaSqlDslUsingKtormSpringTransaction(employee)
    }

    @PostMapping("/employees/ktorm-entity")
    fun createEmployeeViaKtormEntity(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaKtormEntity(employee)
    }

    @PostMapping("/employees/ktorm-annotation")
    fun createEmployeeViaKtormAnnotation(@RequestBody employee: Employee) {

        employeeService.createEmployeeViaKtormAnnotation(employee)
    }
}