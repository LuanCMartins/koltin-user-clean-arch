package io.github.luancmartins.user.usecases

import io.github.luancmartins.user.User
import io.github.luancmartins.user.contracts.UserGateway
import io.github.luancmartins.user.exception.PersistenceErrorException
import io.github.luancmartins.user.usecase.RegisterUserUseCase

class RegisterUser(private val userRepo: UserGateway): RegisterUserUseCase {
    override fun execute(user: User): User {
        val savedUsed = userRepo.save(user)
            ?: throw PersistenceErrorException("Erro ao salvar novo usuário")
        return savedUsed
    }
}