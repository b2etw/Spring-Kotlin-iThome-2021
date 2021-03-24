package com.example.demo.nosql.service.impl

import com.example.demo.nosql.data.dto.UserDto
import com.example.demo.nosql.data.repository.UserRepository
import com.example.demo.nosql.service.UserService
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {

    override fun addUser(userDto: UserDto) = userRepository.save(userDto.toEntity()).toDto()

    override fun queryUsersByAge(age: Int) =
        userRepository.findByAge(age).map {
            it.toDto()
        }.toList()

    override fun modifyUser(userDto: UserDto) =
        userRepository.findById(ObjectId(userDto.id)).orElseThrow {
            RuntimeException()
        }.apply {
            this.firstName = userDto.name.split(",")[0]
            this.lastName = userDto.name.split(",")[1]
            this.age = userDto.age
        }.run {
            userRepository.save(this).toDto()
        }

    override fun removeUserById(id: String) = userRepository.deleteById(ObjectId(id))
}
