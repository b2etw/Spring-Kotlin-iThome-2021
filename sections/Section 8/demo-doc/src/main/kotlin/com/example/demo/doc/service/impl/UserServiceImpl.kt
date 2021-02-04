package com.example.demo.doc.service.impl

import com.example.demo.doc.data.dto.UserDto
import com.example.demo.doc.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    override fun addUser(userDto: UserDto) = userDto.copy(id = 1)

    override fun queryUserById(id: Long) = UserDto(id, "Vincent", "Huang", 88)

    override fun modifyUser(userDto: UserDto) = userDto

    override fun removeUserById(id: Long) {}
}