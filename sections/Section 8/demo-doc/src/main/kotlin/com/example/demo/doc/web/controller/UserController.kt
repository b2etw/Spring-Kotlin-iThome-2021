package com.example.demo.doc.web.controller

import com.example.demo.doc.data.dto.UserDto
import com.example.demo.doc.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @Operation(summary = "add user")
    @PostMapping
    fun addUser(@RequestBody userDto: UserDto) = userService.addUser(userDto)

    @Operation(summary = "get user by id")
    @GetMapping
    fun queryUserById(@Parameter(description = "user id") @RequestParam id: Long) = userService.queryUserById(id)

    @Operation(summary = "modify user")
    @PutMapping
    fun modifyUser(@RequestBody userDto: UserDto) = userService.modifyUser(userDto)

    @Operation(summary = "remove user by id")
    @DeleteMapping
    fun removeUserById(@Parameter(description = "user id") @RequestParam id: Long) = userService.removeUserById(id)
}