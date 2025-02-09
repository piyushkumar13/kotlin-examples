package com.example.springbootkotlinktorm.repository.impl

import com.example.springbootkotlinktorm.domain.Departments
import com.example.springbootkotlinktorm.domain.Employees
import com.example.springbootkotlinktorm.domain.value.Emp
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.schema.ColumnDeclaring
import org.ktorm.support.postgresql.ilike
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
class KtormSqlDslVariousApisRepositoryImpl(private val database: Database) {

    /* ============================= Select clause ================= */
    fun findAllEmployees() {

        val getAllQRes =
            database.from(Employees)
                .select()

        /* Following with like show the sql query. Also, if we enable debug logs, we will get the sql query.
        * But, in both the cases, sql query will be unresolved parameter query. Though, we cannot get the resolved query but
        * we can get the parameters, when debug logs is enabled. Parameters are logged in the flow :
        * Query.rowSet -> database.executeQuery(expression) -> executeExpression(expression) */
        println("getAllQRes Sql query is :::: ${getAllQRes.sql}")

        /* Queries are lazy in nature. Queries won't get called unless we try to fetch result by using method on Query object */
        /* Following functions/properties calls query. */
        println("Fetches a single record for getAllQRes ::: " + getAllQRes.rowSet)


        val emps = getAllQRes.map { row ->
            Emp(id = row[Employees.id], name = row[Employees.name], companyName = row[Employees.company], deptId = null)
        }
        println("Emps are :::: $emps")

        /* We can also do below */
//        getAllQRes.forEach {
//            println(it[Employees.id])
//            println(it[Employees.name])
//            println(it[Employees.company])
//        }

    }

    fun selectFieldsEmployees() {

        database.from(Employees).select(Employees.id, Employees.company)
            .forEach {
                println("Id :: ${it[Employees.id]}")
                println("Company :: ${it[Employees.company]}")
            }

    }

    fun selectFieldsWithMinMaxSalaryOfEmployees() {

        database.from(Employees).select((max(Employees.salary) - min(Employees.salary)).aliased("Computed salary"))
            .forEach {
                println("Computed salary :: ${it.getDouble("Computed salary")}")
            }
    }

    fun selectDistinct() {

        database.from(Employees).selectDistinct(Employees.job)
            .forEach {
                println("Job :: ${it[Employees.job]}")
            }
    }

    /* ============================= Where clause ================= */
    fun findEmployeesByWhereClauseWithAnd() {

        val getByDeptIdAndEmpNameQRes =
            database.from(Employees)
                .select()
                .where((Employees.departmentId eq 1) and (Employees.job ilike "%engineers%"))

        println("getByDeptIdAndEmpNameQRes Sql query is :::: ${getByDeptIdAndEmpNameQRes.sql}")

        println("Fetches a single record for getByDeptIdAndEmpNameQRes ::: " + getByDeptIdAndEmpNameQRes.rowSet)

        getByDeptIdAndEmpNameQRes.forEach {
            println(it[Employees.id])
            println(it[Employees.name])
            println(it[Employees.company])
        }
    }

    fun findEmployeesByWhereClauseWithOr() {

        val getByDeptIdAndEmpNameQRes =
            database.from(Employees)
                .select()
                .where((Employees.departmentId eq 1) or (Employees.name ilike "%data%"))

        println("getByDeptIdAndEmpNameQRes Sql query is :::: ${getByDeptIdAndEmpNameQRes.sql}")

        println("Fetches a single record for getByDeptIdAndEmpNameQRes ::: " + getByDeptIdAndEmpNameQRes.rowSet)

        getByDeptIdAndEmpNameQRes.forEach {
            println(it[Employees.id])
            println(it[Employees.name])
            println(it[Employees.company])
        }
    }

    /* Sometimes, we want to add filter condition dynamically, based on some condition, we can achieve that as well in ktorm. */
    fun findEmployeesByDynamicWhereClause(companyName: String?, job: String?) {

        val qRes = database.from(Employees)
            .select(Employees.name)
            .where {
                val conditions = ArrayList<ColumnDeclaring<Boolean>>()

                if (companyName != null) {

                    conditions += Employees.company eq companyName
                }

                if (job != null) {
                    conditions += Employees.job eq job
                }

                conditions.reduce { a, b -> a and b }
            }

        qRes.forEach { println("Emp name is ::: ${it[Employees.name]}") }
    }

    /* There is a bug in the query in method findEmployeesByDynamicWhereClause, that the reduce operation may throw an exception
       if the list is empty, all conditions are not matched. To avoid this exception, we can replace the reduce operation
       with conditions.combineConditions or even better way is to use whereWithConditions clause*/

    fun findEmployeesByWhereWithConditionsClause(companyName: String?, job: String?) {

        val qRes = database.from(Employees)
            .select(Employees.name)
            .whereWithConditions {
                if (companyName != null) {

                    it += Employees.company eq companyName
                }

                if (job != null) {
                    it += Employees.job eq job
                }
            }

        qRes.forEach { println("Emp name is ::: ${it[Employees.name]}") }
    }

    fun findEmployeesByGroupClause() {

        val qRes = database.from(Employees)
            .select(count(Employees.name).aliased("Employees Count"), Employees.job, Employees.managerId)
            .groupBy(Employees.job, Employees.managerId)

        qRes.forEach {
            println(
                "Emp count is ::: ${it.getInt("Employees Count")} " +
                        "and Job is :: ${it[Employees.job]} " +
                        "and Manger id is ::: ${it[Employees.managerId]}"
            )
        }
    }

    fun findEmployeesByHavingClause() {

        val qRes = database.from(Employees)
            .select(avg(Employees.salary).aliased("Employees Salary"), Employees.job, Employees.managerId)
            .groupBy(Employees.job, Employees.managerId)
            .having(avg(Employees.salary) gt 60.0)

        qRes.forEach {
            println(
                "Emp avg salary is ::: ${it.getDouble("Employees Salary")} " +
                        "and Job is :: ${it[Employees.job]} " +
                        "and Manger id is ::: ${it[Employees.managerId]}"
            )
        }
    }

    fun findEmployeesByOrderClause() {

        val qResOrderByWithoutAlias = database.from(Employees)
            .select(avg(Employees.salary).aliased("Employees Salary"), Employees.departmentId)
            .groupBy(Employees.departmentId)
            .orderBy(avg(Employees.salary).desc())


        qResOrderByWithoutAlias.forEach {
            println(
                "Order by without alias: Emp avg salary is ::: ${it.getDouble("Employees Salary")} and Department id is :: ${it[Employees.departmentId]}"
            )
        }

        val empSalaryAlias = avg(Employees.salary).aliased("Employees Salary")
        val qResOrderByWithAlias = database.from(Employees)
            .select(empSalaryAlias, Employees.departmentId)
            .groupBy(Employees.departmentId)
            .orderBy(empSalaryAlias.desc())

        qResOrderByWithAlias.forEach {
            println(
                "Order by with alias: Emp avg salary is ::: ${it.getDouble("Employees Salary")} and Department id is :: ${it[Employees.departmentId]}"
            )
        }

    }

    fun findEmployeesByLimitClause() {

        val qRes = database.from(Employees)
            .select(Employees.id, Employees.name)
//            .limit(0,2)
            .limit(1, 2)

        println("Total records are ::: ${qRes.totalRecordsInAllPages}")
        qRes.forEach {
            println("Emp id is ::: ${it[Employees.id]} and Emp name is :: ${it[Employees.name]}")
        }

    }


    /* ============================= Join clause ================= */

    fun findEmployeesByCrossJoin() {

        val qRes = database.from(Employees)
            .crossJoin(Departments)
            .select()

        val joinStrLambda: (row: QueryRowSet) -> CharSequence =
            { "name : ${it[Employees.name].toString()} and id : ${it[Employees.id].toString()}" }

        println("Record set ::: " + qRes.joinToString(transform = joinStrLambda))

    }

    fun findEmployeesByInnerJoin() {

        val qRes = database.from(Employees)
            .innerJoin(Departments, on = Employees.departmentId eq Departments.id)
            .select()

        qRes.forEach {
            println("Emp Id: ${it[Employees.id]}")
            println("Emp Name: ${it[Employees.name]}")
            println("DeptId: ${it[Departments.id]}")
            println("Dept Name: ${it[Departments.name]}")
        }
    }
}