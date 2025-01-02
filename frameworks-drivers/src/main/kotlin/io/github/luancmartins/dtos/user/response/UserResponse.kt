package io.github.luancmartins.dtos.user.response

data class UserResponse(
    val id: Long? = 0,
    val active: Boolean = true,
    val name: String = "no-name",
    val email: String = "no-email",
)
