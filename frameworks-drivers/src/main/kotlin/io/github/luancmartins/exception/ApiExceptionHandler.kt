package io.github.luancmartins.exception

import io.github.luancmartins.user.exception.PersistenceErrorException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
class ApiExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(RegisterNotFoundException::class), (DuplicatedRegisterException::class)])
    fun handleBadRequestExceptions(exception: Exception): ResponseEntity<Any> {
        val badRequestStatus = HttpStatus.BAD_REQUEST
        val message = exception.message ?: "Bad Request - No message"

        val apiException = ApiException(
            message,
            exception,
            badRequestStatus,
            LocalDateTime.now()
        )
        return ResponseEntity(apiException, badRequestStatus)
    }

    @ExceptionHandler(value = [(PersistenceErrorException::class)])
    fun handlePersistenceError(exception: Exception): ResponseEntity<Any> {
        val internalServerErrorStatus = HttpStatus.INTERNAL_SERVER_ERROR
        val message = exception.message ?: "Internal Server Error - No message"

        val apiException = ApiException(
            message,
            exception,
            internalServerErrorStatus,
            LocalDateTime.now()
        )
        return ResponseEntity(apiException, internalServerErrorStatus)
    }
}