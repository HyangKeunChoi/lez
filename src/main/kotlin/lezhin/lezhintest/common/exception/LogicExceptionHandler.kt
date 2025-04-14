package lezhin.lezhintest.common.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class LogicExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BadCredentialsException::class)
    fun badCredentialsException(e: BadCredentialsException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse.builder(e, HttpStatus.UNAUTHORIZED, "Invalid credentials")
            .build()

        return ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED)
    }

    @ResponseBody
    @ExceptionHandler(Exception::class)
    fun defaultException(e: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse.builder(e, HttpStatus.INTERNAL_SERVER_ERROR, "internal server error")
            .build()
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ResponseBody
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse.builder(e, HttpStatus.BAD_REQUEST, "argument not valid")
            .build()
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

}