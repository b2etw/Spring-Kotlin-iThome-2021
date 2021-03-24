package com.example.demo.nosql.web

import com.example.demo.nosql.data.dto.UserDto
import com.example.demo.nosql.service.UserService
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

    @PostMapping
    fun addUser(@RequestBody userDto: UserDto) = userService.addUser(userDto)

    @GetMapping
    fun queryUsersByAge(@RequestParam age: Int) = userService.queryUsersByAge(age)

    @PutMapping
    fun modifyUser(@RequestBody userDto: UserDto) = userService.modifyUser(userDto)

    @DeleteMapping
    fun removeUserById(@RequestParam id: String) = userService.removeUserById(id)
}