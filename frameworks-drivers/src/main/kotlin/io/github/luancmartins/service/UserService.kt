package io.github.luancmartins.service

import io.github.luancmartins.user.usecases.GetUserById
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService (private val getUserById: GetUserById) {

    fun getById(id: Long): ResponseEntity<String> {
        val user = getUserById.execute(id)
        return ResponseEntity.ok(user.nome)
    }
}