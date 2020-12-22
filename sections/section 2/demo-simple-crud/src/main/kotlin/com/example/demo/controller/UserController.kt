package com.example.demo.controller

import com.example.demo.data.dto.UserDto
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class UserController(
        val userService: UserService
) {

    @PostMapping("/user")
    fun addUser(@RequestBody userDto: UserDto, req: HttpServletRequest) = userService.addUser(userDto)

    @GetMapping("/user")
    fun findUserById(@RequestParam id: Long) = userService.findUserById(id)

    @PutMapping("/user")
    fun modifyUser(@RequestBody userDto: UserDto) = userService.modifyUser(userDto)

    @DeleteMapping("/user")
    fun removeUserById(@RequestParam id: Long) = userService.removeUserById(id)
}