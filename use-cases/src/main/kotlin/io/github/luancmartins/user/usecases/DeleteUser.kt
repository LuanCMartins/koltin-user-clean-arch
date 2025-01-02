package io.github.luancmartins.user.usecases

import io.github.luancmartins.exception.RegisterNotFoundException
import io.github.luancmartins.user.contracts.UserGateway
import io.github.luancmartins.user.exception.PersistenceErrorException
import io.github.luancmartins.user.usecase.DeleteUserUseCase

class DeleteUser(private val userRepo: UserGateway): DeleteUserUseCase {

    override fun execute(id: Long) {
        val user = userRepo.findById(id)
            ?: throw RegisterNotFoundException("User not found with informed id $id")
        user.active = false
        userRepo.save(user)
            ?: throw PersistenceErrorException("Error while deactivating user with id $id")
    }
}