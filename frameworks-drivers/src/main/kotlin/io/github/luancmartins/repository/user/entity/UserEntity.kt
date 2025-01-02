package io.github.luancmartins.repository.user.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class UserEntity(
    @Id @GeneratedValue
    val id: Long = 0,
    val nome: String = "no-name",
    val email: String = "no-email"
)