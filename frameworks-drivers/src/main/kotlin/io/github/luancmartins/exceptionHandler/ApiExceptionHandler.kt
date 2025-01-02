package io.github.luancmartins.exceptionHandler

import io.github.luancmartins.exception.DuplicatedRegisterException
import io.github.luancmartins.exception.RegisterNotFoundException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
class ApiExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(RegisterNotFoundException::class)])
    fun handleRegisterNotFound(exception: Exception): ResponseEntity<Any> {
        val badRequestStatus = HttpStatus.BAD_REQUEST;
        val message = exception.message ?: "No message";

        val apiException = ApiException(
            message,
            exception,
            badRequestStatus,
            LocalDateTime.now()
        )
        return ResponseEntity(apiException, badRequestStatus);
    }
}