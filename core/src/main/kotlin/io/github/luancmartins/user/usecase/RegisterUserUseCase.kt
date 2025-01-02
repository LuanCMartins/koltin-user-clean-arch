package io.github.luancmartins.user.usecase

import io.github.luancmartins.user.User

interface RegisterUserUseCase {
    fun execute(user: User): User
}