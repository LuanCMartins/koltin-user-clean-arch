package io.github.luancmartins.repository.user

import io.github.luancmartins.extensions.toEntity
import io.github.luancmartins.extensions.toModel
import io.github.luancmartins.repository.user.entity.UserEntity
import io.github.luancmartins.user.User
import io.github.luancmartins.user.contracts.UserGateway
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userDAO: UserDAO,
    private val manager: EntityManager,
): UserGateway {
    override fun findById(id: Long): User? {
        val entity = userDAO.findById(id)
        if (entity.isEmpty)
            return null
        return User(
            entity.get().id,
            entity.get().name,
            entity.get().email
        )
    }

    override fun findByEmail(email: String): User? {
        val query = manager.createQuery("FROM ${UserEntity::class.simpleName} WHERE email = :email",
            UserEntity::class.java)
        query.setParameter("email", email)
        return query.singleResult.toModel()
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