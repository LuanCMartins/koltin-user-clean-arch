package io.github.luancmartins.user.usecase

import io.github.luancmartins.user.User

interface GetUserByIdUseCase {
    fun execute(id: Long): User
}