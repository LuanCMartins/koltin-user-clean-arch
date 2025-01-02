package io.github.luancmartins

import io.github.luancmartins.user.contracts.UserGateway
import io.github.luancmartins.user.usecases.DeleteUser
import io.github.luancmartins.user.usecases.GetAllUsers
import io.github.luancmartins.user.usecases.GetUserById
import io.github.luancmartins.user.usecases.RegisterUser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCasesBeansConfiguration {
    @Bean
    fun getUserById(userRepo: UserGateway): GetUserById {
        return GetUserById(userRepo)
    }

    @Bean
    fun getAllUsers(userRepo: UserGateway): GetAllUsers {
        return GetAllUsers(userRepo)
    }

    @Bean
    fun registerUser(userRepo: UserGateway): RegisterUser {
        return RegisterUser(userRepo)
    }

    @Bean
    fun deleteUser(userRepo: UserGateway): DeleteUser {
        return DeleteUser(userRepo)
    }
}