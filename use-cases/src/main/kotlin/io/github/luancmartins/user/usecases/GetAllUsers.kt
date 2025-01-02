package io.github.luancmartins.user.usecases

import io.github.luancmartins.user.User
import io.github.luancmartins.user.contracts.UserGateway
import io.github.luancmartins.user.usecase.GetAllUsersUseCase

class GetAllUsers(private val userRepo: UserGateway): GetAllUsersUseCase {

    override fun execute(): List<User> {
        return userRepo.findAll()
    }
}