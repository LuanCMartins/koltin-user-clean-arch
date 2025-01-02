package io.github.luancmartins.user.usecases

import io.github.luancmartins.exception.RegisterNotFoundException
import io.github.luancmartins.user.User
import io.github.luancmartins.user.contracts.UserGateway
import io.github.luancmartins.user.usecase.GetUserByIdUseCase

class GetUserById(private val userRepo: UserGateway): GetUserByIdUseCase {

    override fun execute(id: Long): User {
        val user = userRepo.findById(id) ?:throw RegisterNotFoundException("User with id $id not found")
        return user
    }
}