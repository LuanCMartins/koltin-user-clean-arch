package io.github.luancmartins.repository.user

import io.github.luancmartins.user.User
import io.github.luancmartins.user.contracts.UserGateway
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(private val userDAO: UserDAO): UserGateway {
    override fun findById(id: Long): User? {
        val entity = userDAO.findById(id)
        if (entity.isEmpty)
            return null
        return User(
            entity.get().id,
            entity.get().nome,
            entity.get().email
        )
    }
}