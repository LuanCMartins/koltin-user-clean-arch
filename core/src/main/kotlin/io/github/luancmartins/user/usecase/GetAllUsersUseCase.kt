package io.github.luancmartins.user.usecase

import io.github.luancmartins.user.User

interface GetAllUsersUseCase {
    fun execute(): List<User>
}