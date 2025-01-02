package io.github.luancmartins.controller

import io.github.luancmartins.dtos.user.UserResponse
import io.github.luancmartins.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping(produces = ["application/json"])
    fun getById(@RequestParam("user-id") userId: Long): ResponseEntity<UserResponse> {
        return userService.getById(userId)
    }

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<UserResponse>> {
        return userService.getAll()
    }
}