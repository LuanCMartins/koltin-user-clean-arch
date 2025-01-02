package io.github.luancmartins.repository.user

import io.github.luancmartins.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDAO: JpaRepository<UserEntity, Long> {
}