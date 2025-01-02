package io.github.luancmartins.dtos.user.request

data class RegisterUserRequest(
    val nome: String = "",
    val email: String = "",
)