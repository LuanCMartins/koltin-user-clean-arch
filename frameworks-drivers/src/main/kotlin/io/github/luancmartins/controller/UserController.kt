package io.github.luancmartins.controller

import io.github.luancmartins.dtos.user.request.RegisterUserRequest
import io.github.luancmartins.dtos.user.response.UserResponse
import io.github.luancmartins.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<UserResponse>> {
        return userService.getAll()
    }

    @PostMapping
    fun register(@RequestBody request: RegisterUserRequest): ResponseEntity<UserResponse> {
        return userService.register(request)
    }
}