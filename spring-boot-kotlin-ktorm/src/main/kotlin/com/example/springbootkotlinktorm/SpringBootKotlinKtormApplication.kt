package com.example.springbootkotlinktorm

import com.example.springbootkotlinktorm.domain.DepartmentJPAEntity
import com.example.springbootkotlinktorm.domain.EmployeeJPAEntity
import com.example.springbootkotlinktorm.repository.DepartmentJPARepository
import com.example.springbootkotlinktorm.repository.EmployeeJPARepository
import net.datafaker.Faker
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import java.time.LocalDate

@SpringBootApplication
//@EnableConfigurationProperties(DbConfigProperties5::class)
@ConfigurationPropertiesScan // We can use this it will scan all the configuration properties falling within the child packages.
class SpringBootKotlinKtormApplication(
    private val employeeJPARepository: EmployeeJPARepository,
    private val departmentJPARepository: DepartmentJPARepository
) : CommandLineRunner {


    override fun run(vararg args: String?) {

        val faker = Faker()

        val dept1 = "CP"
        val dept1Id = 1
        val dept2 = "CDP"
        val dept2Id = 2
        val dept3 = "GC"

        for (i in 1..10) {

            if (i in 1..5) {
                val departmentJPAEntity = DepartmentJPAEntity(id = dept1Id, name = dept1)
                val employeeJPAEntity = EmployeeJPAEntity(
                    id = i,
                    name = faker.name().fullName(),
                    company = faker.company().name(),
                    job = "Engineers",
                    hireDate = LocalDate.now(),
                    managerId = "1",
                    salary = 100.0,
                    department = departmentJPAEntity
                )

                employeeJPARepository.save(employeeJPAEntity)

            } else {
                val departmentJPAEntity = DepartmentJPAEntity(id = dept2Id, name = dept2)
                val employeeJPAEntity = EmployeeJPAEntity(
                    id = i,
                    name = faker.name().fullName(),
                    company = faker.company().name(),
                    job = "Data Engineers",
                    hireDate = LocalDate.now(),
                    managerId = "2",
                    salary = 50.0,
                    department = departmentJPAEntity
                )

                employeeJPARepository.save(employeeJPAEntity)
            }
        }

        for (i in 3..5){
            val departmentJPAEntity = DepartmentJPAEntity(id = i, name = dept3)
            departmentJPARepository.save(departmentJPAEntity)

        }
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinKtormApplication>(*args)

    /* We can also use following two ways to start spring boot application which is similar to what we do in java. */
//    SpringApplication.run(SpringBootKotlinKtormApplication::class.java, *args)
//    SpringApplication.run(arrayOf(SpringBootKotlinKtormApplication::class.java), args)

}




