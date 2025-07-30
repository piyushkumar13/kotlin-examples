///*
// *  Copyright (c) 2024 Piyush Kumar
// *  All Rights Reserved Worldwide.
// */package com.example.springbootkotlinktorm.repository.impl
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//
///**
// * @author Piyush Kumar.
// * @since 08/02/25.
// */
//
//@SpringBootTest
//class KtormEntitySequenceVariousApisRepositoryImplTest(@Autowired private val entitySeqVariousApisRepositoryImpl: KtormEntitySequenceVariousApisRepositoryImpl) {
//
//    @Test
//    fun testFindEmployees(){
//        entitySeqVariousApisRepositoryImpl.findEmployees()
//    }
//
//    @Test
//    fun testFindEmployeesWithDisabledLeftJoining(){
//
//        entitySeqVariousApisRepositoryImpl.findEmployeesWithDisabledLeftJoining()
//    }
//
//    @Test
//    fun testFindEmployeesAndReturnAsList(){
//
//        entitySeqVariousApisRepositoryImpl.testFindEmployeesAndReturnAsList()
//    }
//
//    @Test
//    fun testFindEmployeeById(){
//        entitySeqVariousApisRepositoryImpl.findEmployeeById()
//    }
//
//    @Test
//    fun testFindEmployeeByDeptId(){
//        entitySeqVariousApisRepositoryImpl.findEmployeeByDeptId()
//    }
//
//    @Test
//    fun testFindEmployeeWithFilter(){
//        entitySeqVariousApisRepositoryImpl.findEmployeeWithFilter()
//    }
//
//
//    @Test
//    fun testFindEmployeeWithLesserColumnsSelect(){
//        entitySeqVariousApisRepositoryImpl.findEmployeeWithLesserColumnsSelect()
//    }
//
//    @Test
//    fun testFindEmployeeWithOnlyPrimaryKeyColumnsSelect(){
//        entitySeqVariousApisRepositoryImpl.findEmployeeWithOnlyPrimaryKeyColumnsSelect()
//    }
//
//
//    @Test
//    fun testFindEmployeeBySalaryOrder(){
//        entitySeqVariousApisRepositoryImpl.findEmployeeBySalaryOrder()
//    }
//
//    @Test
//    fun testFindEmployeeByMultiFieldOrder(){
//        entitySeqVariousApisRepositoryImpl.findEmployeeByMultiFieldOrder()
//    }
//
//    @Test
//    fun testFindEmployeesByLimitDropAndTake(){
//        entitySeqVariousApisRepositoryImpl.findEmployeesByLimitDropAndTake()
//    }
//
//    @Test
//    fun testFindEmployeesAndReturnCollection(){
//        entitySeqVariousApisRepositoryImpl.findEmployeesAndReturnCollection()
//    }
//
//    @Test
//    fun testFindEmployeesAndReturnName() {
//        entitySeqVariousApisRepositoryImpl.findEmployeesAndReturnName()
//    }
//
//    @Test
//    fun testFindEmployeesAndReturnNameUsingMapColumnFunction(){
//        entitySeqVariousApisRepositoryImpl.findEmployeesAndReturnNameUsingMapColumnFunction()
//    }
//
//    @Test
//    fun testFindEmployeesAvgSalary(){
//        entitySeqVariousApisRepositoryImpl.findEmployeesAvgSalary()
//    }
//
//    @Test
//    fun testFindEmployeesAvgMaxMinSalary(){
//        entitySeqVariousApisRepositoryImpl.findEmployeesAvgMaxMinSalary()
//    }
//
//    @Test
//    fun testFindEmpByDept(){
//        entitySeqVariousApisRepositoryImpl.findEmpByDept()
//    }
//
//    @Test
//    fun testFindEmpAvgSalaryByDept(){
//        entitySeqVariousApisRepositoryImpl.findEmpAvgSalaryByDept()
//    }
//
//    @Test
//    fun testFindEmpByDeptAvgSalaryUsingGroupingBy(){
//        entitySeqVariousApisRepositoryImpl.findEmpByDeptAvgSalaryUsingGroupingBy()
//    }
//}