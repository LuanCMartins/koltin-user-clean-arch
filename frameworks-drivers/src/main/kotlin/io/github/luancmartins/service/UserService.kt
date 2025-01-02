package io.github.luancmartins.service

import io.github.luancmartins.dtos.user.request.RegisterUserRequest
import io.github.luancmartins.dtos.user.response.UserResponse
import io.github.luancmartins.extensions.toModel
import io.github.luancmartins.extensions.toResponse
import io.github.luancmartins.user.usecase.DeleteUserUseCase
import io.github.luancmartins.user.usecase.GetAllUsersUseCase
import io.github.luancmartins.user.usecase.GetUserByIdUseCase
import io.github.luancmartins.user.usecase.RegisterUserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService (
    private val getUserById: GetUserByIdUseCase,
    private val getAllUsers: GetAllUsersUseCase,
    private val registerUser: RegisterUserUseCase,
    private val deleteUser: DeleteUserUseCase,
) {

    fun getById(id: Long): ResponseEntity<UserResponse> {
        val user = getUserById.execute(id)
        return ResponseEntity.ok(user.toResponse())
    }

    fun getAll(): ResponseEntity<List<UserResponse>> {
        val users = getAllUsers.execute()
        return ResponseEntity.ok(users.map { it.toResponse() })
    }

    fun register(request: RegisterUserRequest): ResponseEntity<UserResponse> {
        val user = request.toModel()
        val newUser = registerUser.execute(user)
        return ResponseEntity.ok(newUser.toResponse())
    }

    fun deleteById(userId: Long): ResponseEntity<String> {
        deleteUser.execute(userId)
        return ResponseEntity.ok("User successfully deleted!")
    }
}