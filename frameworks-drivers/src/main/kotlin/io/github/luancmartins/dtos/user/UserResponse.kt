package io.github.luancmartins.dtos.user

data class UserResponse(
    val id: Long? = 0,
    val nome: String = "no-name",
    val email: String = "no-email",
)
