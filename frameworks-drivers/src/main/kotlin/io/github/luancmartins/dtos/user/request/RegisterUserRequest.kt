package io.github.luancmartins.dtos.user.request

data class RegisterUserRequest(
    val name: String = "",
    val email: String = "",
)