package io.github.luancmartins.repository.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq")
    val id: Long? = null,
    val nome: String = "no-name",
    val email: String = "no-email"
)