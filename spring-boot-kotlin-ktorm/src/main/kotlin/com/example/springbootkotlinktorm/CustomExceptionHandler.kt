package com.example.springbootkotlinktorm

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


/**
 * @author Piyush Kumar.
 * @since 01/10/24.
 */

@RestControllerAdvice
class CustomExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [IllegalArgumentException::class])
    fun handleBadReq(ex: RuntimeException, request: WebRequest): ResponseEntity<Any>? {

        val bodyOfResponse = "bad request from custom global exception handler"
        return handleExceptionInternal(ex, bodyOfResponse, HttpHeaders(), HttpStatus.BAD_REQUEST, request)
    }
}