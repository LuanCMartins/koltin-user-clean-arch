package io.github.luancmartins.exceptionHandler

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class ApiException(
    message: String,
    val throwable: Throwable,
    val httpStatus: HttpStatus,
    val timeStamp: LocalDateTime,
): Exception(message)