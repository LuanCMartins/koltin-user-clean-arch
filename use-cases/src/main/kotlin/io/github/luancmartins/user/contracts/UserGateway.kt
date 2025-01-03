package io.github.luancmartins.user.contracts

import io.github.luancmartins.user.User

interface UserGateway {
    fun findById(id: Long) : User?
    fun findByEmail(email: String): User?
    fun findAll(): List<User>
    fun save(user: User): User?
}