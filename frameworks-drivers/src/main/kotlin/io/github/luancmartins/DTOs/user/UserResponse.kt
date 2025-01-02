package io.github.luancmartins.DTOs.user

data class UserResponse(
    private val id: Long? = 0,
    private val nome: String,
    private val email: String,
)
