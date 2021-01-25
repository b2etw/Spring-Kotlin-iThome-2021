package com.example.demo.service

import com.example.demo.data.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun findUserById(id: Long): UserDto

    fun modifyUser(userDto: UserDto): UserDto

    fun removeUserById(id: Long): Unit
}