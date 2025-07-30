///*
// *  Copyright (c) 2024 Piyush Kumar
// *  All Rights Reserved Worldwide.
// */
//package com.example.springbootkotlinktorm.repository.impl
//
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//
///**
// * @author Piyush Kumar.
// * @since 07/02/25.
// */
//
//@SpringBootTest
//class KtormSqlDslVariousApisRepositoryImplTest(@Autowired private val sqlDslVariousApisRepository: KtormSqlDslVariousApisRepositoryImpl) {
//
//    @Test
//    fun testFindAllEmployees() {
//
//        sqlDslVariousApisRepository.findAllEmployees()
//    }
//
//    @Test
//    fun testSelectFieldsEmployees() {
//        sqlDslVariousApisRepository.selectFieldsEmployees()
//    }
//
//    @Test
//    fun testSelectFieldsWithMinMaxSalaryOfEmployees() {
//
//        sqlDslVariousApisRepository.selectFieldsWithMinMaxSalaryOfEmployees()
//    }
//
//    @Test
//    fun testSelectDistinct() {
//
//        sqlDslVariousApisRepository.selectDistinct()
//    }
//
//    @Test
//    fun testFindEmployeesByWhereClauseWithAnd() {
//
//        sqlDslVariousApisRepository.findEmployeesByWhereClauseWithAnd()
//    }
//
//    @Test
//    fun testFindEmployeesByWhereClauseWithOr() {
//
//        sqlDslVariousApisRepository.findEmployeesByWhereClauseWithOr()
//    }
//
//    @Test
//    fun testFindEmployeesByDynamicWhereClause() {
//
//        sqlDslVariousApisRepository.findEmployeesByDynamicWhereClause(null, "Engineers")
//    }
//
//    @Test
//    fun testFindEmployeesByWhereWithConditionsClause() {
//
//        sqlDslVariousApisRepository.findEmployeesByWhereWithConditionsClause(null, "Engineers")
//    }
//
//    @Test
//    fun testFindEmployeesByGroupClause() {
//
//        sqlDslVariousApisRepository.findEmployeesByGroupClause()
//    }
//
//    @Test
//    fun testFindEmployeesByHavingClause() {
//
//        sqlDslVariousApisRepository.findEmployeesByHavingClause()
//    }
//
//    @Test
//    fun testFindEmployeesByOrderClause() {
//
//        sqlDslVariousApisRepository.findEmployeesByOrderClause()
//    }
//
//    @Test
//    fun testFindEmployeesByLimitClause() {
//
//        sqlDslVariousApisRepository.findEmployeesByLimitClause()
//    }
//
//    @Test
//    fun testFindEmployeesByCrossJoin() {
//
//        sqlDslVariousApisRepository.findEmployeesByCrossJoin()
//    }
//
//    @Test
//    fun testFindEmployeesByInnerJoin() {
//
//        sqlDslVariousApisRepository.findEmployeesByInnerJoin()
//    }
//}