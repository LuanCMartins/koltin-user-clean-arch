package io.github.luancmartins.user.usecases

import io.github.luancmartins.exception.DuplicatedRegisterException
import io.github.luancmartins.user.User
import io.github.luancmartins.user.contracts.UserGateway
import io.github.luancmartins.user.exception.PersistenceErrorException
import io.github.luancmartins.user.usecase.RegisterUserUseCase

class RegisterUser(private val userRepo: UserGateway): RegisterUserUseCase {
    override fun execute(user: User): User {
        val userWithSameEmail = userRepo.findByEmail(user.email)
        if (userWithSameEmail != null)
            throw DuplicatedRegisterException("User already exists with this email")

        val savedUsed = userRepo.save(user)
            ?: throw PersistenceErrorException("Error on save new user ")
        return savedUsed
    }
}