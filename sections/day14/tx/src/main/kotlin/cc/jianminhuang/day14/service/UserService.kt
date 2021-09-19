package cc.jianminhuang.day14.service

import cc.jianminhuang.day14.data.`do`.User
import cc.jianminhuang.day14.data.dto.UserDto

interface UserService {

    fun addUser(user: User): UserDto
}
