package com.example.demo.nosql.service

import com.example.demo.nosql.data.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun queryUsersByAge(age: Int): List<UserDto>

    fun modifyUser(userDto: UserDto): UserDto

    fun removeUserById(id: String)
}
