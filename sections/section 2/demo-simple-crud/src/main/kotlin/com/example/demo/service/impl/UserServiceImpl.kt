package com.example.demo.service.impl

import com.example.demo.data.dto.UserDto
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        val userRepository: UserRepository
) : UserService {

    override fun addUser(userDto: UserDto) = userRepository.save(userDto.trans2Entity()).trans2Dto()

    override fun findUserById(id: Long) =
            userRepository.findById(id).map {
                it.trans2Dto()
            }.orElseThrow {
                RuntimeException()
            }

    override fun modifyUser(userDto: UserDto) =
            userRepository.findById(userDto.id).orElseThrow {
                RuntimeException()
            }.apply {
                this.firstName = userDto.name.split(",")[0].trim()
                this.lastName = userDto.name.split(",")[1].trim()
                this.age = userDto.age
                userRepository.save(this)
            }.run {
                this.trans2Dto()
            }

    override fun removeUserById(id: Long) = userRepository.deleteById(id)
}