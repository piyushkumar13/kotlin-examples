package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.domain.Departments
import com.example.springbootkotlinktorm.domain.Employee
import com.example.springbootkotlinktorm.domain.Employees
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.entity.*
import org.springframework.stereotype.Repository

/**
 *
 * Check its testclass to execute its methods {@link KtormSqlDslVariousApisRepositoryImplTest}
 *
 * @author Piyush Kumar.
 * @since 29/09/24.
 * @see KtormSqlDslVariousApisRepositoryImplTest
 */

@Repository
class KtormEntitySequenceVariousApisRepositoryImpl(private val database: Database) {

    /* We can create entity sequence in following two ways. */
    private val Database.employeeEntity get() = this.sequenceOf(Employees)
    private val Database.departmentEntity get() = this.sequenceOf(Employees)

    private val employeeEntitySeq = database.sequenceOf(Employees)
    private val departmentEntitySeq = database.sequenceOf(Employees)

    fun findEmployees() {

        /* By default, entity sequence */
        database.employeeEntity.forEach {
            println("Using extension property")
            println("Emp id :: ${it.id}")
            println("Emp name :: ${it.name}")
            println("Emp company :: ${it.companyName}")
            println("Emp job :: ${it.job}")
        }

        employeeEntitySeq.forEach {
            println("Using sequenceOf at class level")
            println("Emp id :: ${it.id}")
            println("Emp name :: ${it.name}")
            println("Emp company :: ${it.companyName}")
            println("Emp job :: ${it.job}")
        }

        database.sequenceOf(Employees)
            .forEach {
                println("Using sequenceOf at function level")
                println("Emp id :: ${it.id}")
                println("Emp name :: ${it.name}")
                println("Emp company :: ${it.companyName}")
                println("Emp job :: ${it.job}")
            }
    }

    fun findEmployeesWithDisabledLeftJoining() {
        database.sequenceOf(Employees, withReferences = false).forEach {
            println("Employees are : $it")
        }
    }

    fun testFindEmployeesAndReturnAsList() {
        val empEntityList = database.employeeEntity.toList()

        println("EmpEntityList ::: $empEntityList")
    }


    fun findEmployeeById() {

        val employee: Employee? = database.employeeEntity.find {
            it.id eq 1
        }

        println("Employee is ::: $employee")
    }

    fun findEmployeeByDeptId() {

        val employee = database.employeeEntity.find {

            val referenceTable = it.departmentId.referenceTable
            val kClass = it.departmentId.referenceTable!!::class
            println("Actual Type is : ${it.departmentId.referenceTable!!::class.qualifiedName}")
            val departments: Departments = it.departmentId.referenceTable as Departments
            departments.id eq 1
        }

        println("Employee is :: $employee")
    }

    /* ====================== Intermediate Operations ==================== */
    fun findEmployeeWithFilter() {

        database.employeeEntity
            .filter { it.departmentId eq 1 }
            .forEach { println("Emp ::: $it") }

    }

    fun findEmployeeWithLesserColumnsSelect() {

        val empEntitySequenceByIntermediateOp = database.employeeEntity.filterColumns {
            it.columns - it.departmentId - it.job
        }

        empEntitySequenceByIntermediateOp.forEach {
            println("Employee with lesser columns : $it")
        }
    }

    fun findEmployeeWithOnlyPrimaryKeyColumnsSelect() {

        val empEntitySequenceByIntermediateOp = database.employeeEntity.filterColumns {
            it.primaryKeys
        }

        empEntitySequenceByIntermediateOp.forEach {
            println("Employee only primary key : $it")
        }
    }

    fun findEmployeeBySalaryOrder() {

        database.employeeEntity.sortedBy { it.salary.asc() }.forEach { println("Emp::: $it") }
    }

    fun findEmployeeByMultiFieldOrder() {
        database.employeeEntity.sortedBy({ it.salary.asc() }, { it.name.desc() }).forEach { println("Emp::: $it") }
    }

    fun findEmployeesByLimitDropAndTake() {
        database.employeeEntity.drop(3).take(2).forEach { println("Emps are ::: $it") }
    }

    /* ====================== Terminal Operations ==================== */

    fun findEmployeesAndReturnCollection() {

        val employees = database.employeeEntity.toCollection(ArrayList()) // we can also use toList as well.
        println("Employees are ::: $employees")
    }

    /*According to functional programming usually the map and flatMap functions are intermediate operations.
     However, they are terminal instead in ktorm, which is a compromise of Ktorm’s design.*/
    fun findEmployeesAndReturnName() {
        val namesList = database.employeeEntity.map { it.name }

        println("Names are : $namesList")
    }

    /* In map operation, sql query generated will contain all the columns of the table which will not be efficient if you
     are interested in only one field thats where mapColumns helps which only selects the desired field. Alternatively,
     we can also use filterColumns as well. */
    fun findEmployeesAndReturnNameUsingMapColumnFunction(){
        val names = database.employeeEntity.mapColumns { it.name }
        println("Names are :: $names")
    }

    fun findEmployeesAvgSalary(){

        val avgSalaryOfDept = database.employeeEntity
            .filter { it.departmentId eq 1 }
            .aggregateColumns { avg(it.salary) }

        println("Avg salary ::: $avgSalaryOfDept")
    }

    fun findEmployeesAvgMaxMinSalary(){

        val aggregateResult = database.employeeEntity
            .filter { it.departmentId eq 1 }
            .aggregateColumns { tupleOf(avg(it.salary), max(it.salary),(max(it.salary) - min(it.salary)).aliased("Salary Difference")) }

        println("AggregateResult ::: $aggregateResult")
        println("AggregateResult ::: ${aggregateResult.first}")
        println("AggregateResult ::: ${aggregateResult.second}")
        println("AggregateResult ::: ${aggregateResult.third}")
    }

    /* This groupBy operation performs the grouping in memory not in sql. Basically, sql query is just a simple select statement
    * without using group by clause. */
    fun findEmpByDept(){
        val empByDep = database.employeeEntity.groupBy { it.department?.id }
        println("Emp by dept ::: $empByDep") // map key is dept id and value is list of employees
    }

    /* This groupBy operation performs the grouping in memory as well as averaging in memory, not in sql.
     * Basically, sql query is just a simple select statement without using group by clause. */
    fun findEmpAvgSalaryByDept(){
        val avgSalaryByDept = database.employeeEntity
            .groupBy { it.department?.id }
            .mapValues { (deptId, emps) -> emps.map { it.salary }.average() }
        println("Emp by dept ::: $avgSalaryByDept") // map key is dept id and value is average salary
    }

    /* If we want to perform grouping using sql query that can be done by groupingBy function but this function is
    *  intermediate operation NOT the terminal operation. */
    fun findEmpByDeptAvgSalaryUsingGroupingBy(){
        val avgSalaryByDept = database.employeeEntity
            .groupingBy({ it.departmentId }) // group by multiple field not possible with sequence api.
            .aggregateColumns { avg(it.salary) }

        println("Avg salary by dept ::: $avgSalaryByDept")
    }
}