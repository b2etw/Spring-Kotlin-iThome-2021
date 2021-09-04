package cc.jianminhuang.day2.service

import cc.jianminhuang.day2.data.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun queryUserById(id: Long): UserDto

    fun modifyUser(userDto: UserDto): UserDto

    fun removeUserById(id: Long)
}