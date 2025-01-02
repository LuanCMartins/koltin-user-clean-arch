package io.github.luancmartins.extensions

import io.github.luancmartins.dtos.user.request.RegisterUserRequest
import io.github.luancmartins.dtos.user.response.UserResponse
import io.github.luancmartins.repository.user.entity.UserEntity
import io.github.luancmartins.user.User

fun UserEntity.toModel(): User =
    User(this.id, this.nome, this.email)

fun User.toResponse(): UserResponse =
    UserResponse(this.id, this.nome, this.email)

fun User.toEntity(): UserEntity =
    UserEntity(this.id, this.nome, this.email)

fun RegisterUserRequest.toModel(): User =
    User(null, this.nome, this.email)