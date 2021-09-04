package cc.jianminhuang.day4.service

import cc.jianminhuang.day4.data.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun queryUserById(id: Long): UserDto

    fun modifyUser(userDto: UserDto): UserDto

    fun modifyUserWithAge(userDto: UserDto): UserDto

    fun removeUserById(id: Long)
}