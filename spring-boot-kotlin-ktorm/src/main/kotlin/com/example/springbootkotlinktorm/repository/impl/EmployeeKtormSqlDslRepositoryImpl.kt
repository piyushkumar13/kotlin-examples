package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.controller.dto.Employee
import com.example.springbootkotlinktorm.domain.Departments
import com.example.springbootkotlinktorm.domain.Employees
import com.example.springbootkotlinktorm.domain.value.Emp
import com.example.springbootkotlinktorm.repository.EmployeeKtormSqlDslRepository
import org.ktorm.database.Database
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import javax.sql.DataSource

/**
 * @author Piyush Kumar.
 * @since 29/09/24.
 */

@Repository
// Following is an old way of autoriwing in kotlin. It was used prior to spring 4.3. Now we dont need to explicilty give @Autowired constructor
class EmployeeKtormSqlDslRepositoryImpl @Autowired constructor(val database: Database, val datasource: DataSource) :
    EmployeeKtormSqlDslRepository {


    override fun createEmployeeViaSqlDsl(employeeSqlDsl: Employee) {

        database.insert(Departments) {
            set(it.id, employeeSqlDsl.department.id)
            set(it.name, employeeSqlDsl.department.name)
        }

        database.insert(Employees) {
            set(it.id, employeeSqlDsl.id)
            set(it.name, employeeSqlDsl.name)
            set(it.company, employeeSqlDsl.companyName)
            set(it.departmentId, employeeSqlDsl.department.id)
        }



        println("Record inserted successfully via sql dsl")
    }

    override fun createEmployeeViaSqlDslUsingTransaction(employeeSqlDsl: Employee) {

        database.useTransaction(TransactionIsolation.REPEATABLE_READ) {

            database.insert(Departments) {
                set(it.id, employeeSqlDsl.department.id)
                set(it.name, employeeSqlDsl.department.name)
            }

            println("Department record inserted for transactional demo.")

            throw RuntimeException("Throwing exception to rollback")

//            database.insert(Employees) {
//                set(it.id, employeeSqlDsl.id)
//                set(it.name, employeeSqlDsl.name)
//                set(it.company, employeeSqlDsl.companyName)
//                set(it.departmentId, employeeSqlDsl.department.id)
//            }

        }
    }

    @Transactional
    override fun createEmployeeViaSqlDslUsingSpringTransaction(employeeSqlDsl: Employee) {

        val db = Database.connectWithSpringSupport(datasource)
        db.insert(Departments) {
            set(it.id, employeeSqlDsl.department.id)
            set(it.name, employeeSqlDsl.department.name)
        }

        println("Department record inserted for spring transaction demo.")

//        throw RuntimeException("Throwing exception to rollback using spring transactions")
    }

    override fun getEmployeeViaSqlDsl(empId: Int, deptId: Int): Emp {

        val empQuery: Query = database.from(Employees)
            .select()
            .where(Employees.id eq empId)

        val emp = empQuery
            .map { row ->
                Emp(
                    id = row[Employees.id],
                    name = row[Employees.name],
                    companyName = row[Employees.company],
                    deptId = row[Employees.departmentId]
                )
            }
            .first()

        println("Fetched employee via sql dsl : $emp")

        return emp
    }
}