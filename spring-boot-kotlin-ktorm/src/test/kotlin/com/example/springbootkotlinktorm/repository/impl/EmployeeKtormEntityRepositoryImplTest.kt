//package com.example.springbootkotlinktorm.repository.impl
//
//import com.example.springbootkotlinktorm.controller.dto.Department
//import com.example.springbootkotlinktorm.controller.dto.Employee
//import com.example.springbootkotlinktorm.domain.Employees
//import com.example.springbootkotlinktorm.repository.EmployeeKtormEntityRepository
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.BeforeAll
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.TestInstance
//import org.ktorm.database.Database
//import org.ktorm.dsl.from
//import org.ktorm.dsl.map
//import org.ktorm.dsl.select
//import org.ktorm.entity.map
//import org.ktorm.entity.sequenceOf
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//
//private const val NAME = "this_is_test_name"
//
//@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class EmployeeKtormEntityRepositoryImplTest {
//
//  @Autowired
//  private lateinit var employeeKtormEntityRepository: EmployeeKtormEntityRepository
//
//  @Autowired
//  private lateinit var database: Database
//
//  @BeforeAll
//  fun setUp() {
//    val employee = Employee(
//      1,
//      NAME,
//      "comp",
//      Department(22, "dept")
//    )
//
//    val deptViaKtormEntity = com.example.springbootkotlinktorm.domain.Department {
//      id = employee.department.id
//      name = employee.department.name
//    }
//
//    val employeeViaKtormEntity = com.example.springbootkotlinktorm.domain.Employee {
//      id = employee.id
//      name = employee.name
//      companyName = employee.companyName
//    }
//
//    employeeKtormEntityRepository.createEmployeeViaEntity(employeeViaKtormEntity, deptViaKtormEntity)
//  }
//
//  @Test
//  fun test_select() {
//    val emp = database.from(Employees).select(Employees.name).map { it[Employees.name] }.single()
//
//    assertThat(emp).isEqualTo(NAME)
//
//    println("Fetched record entity is : $emp")
//  }
//
//  @Test
//  fun test_sequenceOf() {
//    val emp = database.sequenceOf(Employees, false).map { it.name }.single()
//
//    assertThat(emp).isEqualTo(NAME)
//
//    println("Fetched record entity is : $emp")
//  }
//}