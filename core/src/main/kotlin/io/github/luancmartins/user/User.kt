package io.github.luancmartins.user

data class User (
    val id: Long? = 0,
    var active: Boolean = true,
    val name: String = "no-name",
    val email: String = "no-email"
)