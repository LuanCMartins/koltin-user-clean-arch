package io.github.luancmartins.service

import io.github.luancmartins.dtos.user.UserResponse
import io.github.luancmartins.extensions.toResponse
import io.github.luancmartins.user.usecases.GetAllUsers
import io.github.luancmartins.user.usecases.GetUserById
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService (
    private val getUserById: GetUserById,
    private val getAllUsers: GetAllUsers
) {

    fun getById(id: Long): ResponseEntity<UserResponse> {
        val user = getUserById.execute(id)
        return ResponseEntity.ok(user.toResponse())
    }

    fun getAll(): ResponseEntity<List<UserResponse>> {
        val users = getAllUsers.execute()
        return ResponseEntity.ok(users.map { it.toResponse() })
    }
}