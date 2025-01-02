package io.github.luancmartins

import io.github.luancmartins.user.contracts.UserGateway
import io.github.luancmartins.user.usecases.GetUserById
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCasesBeansConfiguration {
    @Bean
    fun getUserById(userRepo: UserGateway): GetUserById {
        return GetUserById(userRepo)
    }
}