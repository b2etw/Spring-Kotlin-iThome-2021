package com.example.demo.doc.service

import com.example.demo.doc.data.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun queryUserById(id: Long): UserDto

    fun modifyUser(userDto: UserDto): UserDto

    fun removeUserById(id: Long)
}
