package io.github.luancmartins.controller

import io.github.luancmartins.DTOs.user.UserResponse
import io.github.luancmartins.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getById(@RequestParam("user-id") userId: Long): ResponseEntity<UserResponse> {
        return userService.getById(userId)
    }
}