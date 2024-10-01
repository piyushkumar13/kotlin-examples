package com.example.springbootkotlinktorm.service

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.domain.*
import com.example.springbootkotlinktorm.repository.EmployeeJPARepository
import com.example.springbootkotlinktorm.repository.EmployeeKtormAnnotationRepository
import com.example.springbootkotlinktorm.repository.EmployeeKtormEntityRepository
import com.example.springbootkotlinktorm.repository.EmployeeKtormSqlDslRepository
import org.springframework.stereotype.Service

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */


@Service
class EmployeeServiceImpl(

    private val employeeJPARepository: EmployeeJPARepository,
    private val employeeKtormEntityRepository: EmployeeKtormEntityRepository,
    private val employeeKtormSqlDslRepository: EmployeeKtormSqlDslRepository,
    private val employeeKtormAnnotationRepository: EmployeeKtormAnnotationRepository

) : EmployeeService {

    override fun createEmployeeViaJpa(employee: Employee): Employee {

        val deptEntity = departmentJPAEntity(employee.department.id, employee.department.name)
        val empEntity = empEntity(employee.id, employee.name, employee.companyName, deptEntity)

        employeeJPARepository.save(empEntity)

        println("Record inserted successfully via sql dsl")
        return employee
    }

    override fun createEmployeeViaKtormEntity(employee: Employee): Employee {

        val deptViaKtormEntity = Department {
            id = employee.department.id
            name = employee.department.name
        }

        val employeeViaKtormEntity = com.example.springbootkotlinktorm.domain.Employee {
            id = employee.id
            name = employee.name
            companyName = employee.companyName
        }

        employeeKtormEntityRepository.createEmployeeViaEntity(employeeViaKtormEntity, deptViaKtormEntity)

        println("Record inserted successfully via Ktorm entity")

        return employee;
    }

    override fun createEmployeeViaSqlDsl(employee: Employee): Employee {

        employeeKtormSqlDslRepository.createEmployeeViaSqlDsl(employee)

        println("Record inserted successfully via ktorm sql dsl")

        return employee
    }

    override fun createEmployeeViaSqlDslUsingKtormTransaction(employee: Employee): Employee {

        employeeKtormSqlDslRepository.createEmployeeViaSqlDslUsingTransaction(employee)
        println("Record inserted successfully via ktorm sql dsl using useTransaction")

        return employee
    }

    override fun createEmployeeViaSqlDslUsingKtormSpringTransaction(employee: Employee): Employee {

        employeeKtormSqlDslRepository.createEmployeeViaSqlDslUsingSpringTransaction(employee)
        println("Record inserted successfully via ktorm sql dsl using spring transaction")

        return employee
    }

    override fun createEmployeeViaKtormAnnotation(employee: Employee): Employee {

        val departmentAnnotated = DepartmentAnnotated(
            id = employee.department.id,
            name = employee.department.name
        )
        val employeeAnnotated = EmployeeAnnotated(
            id = employee.id,
            name = employee.name,
            companyName = employee.companyName,
        )

        employeeKtormAnnotationRepository.createEmployee(employeeAnnotated, departmentAnnotated)

        println("Record inserted successfully via ktorm ksr annotations")

        return employee
    }


    private fun empEntity(id: Int, name: String, company: String, deptEntity: DepartmentJPAEntity): EmployeeJPAEntity {

        return EmployeeJPAEntity(
            id = id,
            name = name,
            company = company,
            department = deptEntity
        )
    }

    private fun departmentJPAEntity(id: Int, name: String): DepartmentJPAEntity {

        return DepartmentJPAEntity(
            id = id,
            name = name
        )
    }

}