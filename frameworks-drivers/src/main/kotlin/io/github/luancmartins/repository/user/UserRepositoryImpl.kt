package io.github.luancmartins.repository.user

import io.github.luancmartins.extensions.toEntity
import io.github.luancmartins.extensions.toModel
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

    override fun findAll(): List<User> {
        val entities = userDAO.findAll()
        return entities.map { it.toModel() }
    }

    override fun save(user: User): User? {
        val entity = user.toEntity()
        return userDAO.save(entity).toModel()
    }
}