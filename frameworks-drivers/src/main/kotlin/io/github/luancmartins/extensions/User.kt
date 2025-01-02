package io.github.luancmartins.extensions

import io.github.luancmartins.dtos.user.UserResponse
import io.github.luancmartins.repository.user.entity.UserEntity
import io.github.luancmartins.user.User

fun UserEntity.toModel(): User =
    User(this.id, this.nome, this.email)

fun User.toResponse(): UserResponse =
    UserResponse(this.id, this.nome, this.email)