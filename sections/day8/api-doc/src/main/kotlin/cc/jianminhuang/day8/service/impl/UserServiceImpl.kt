package cc.jianminhuang.day8.service.impl

import cc.jianminhuang.day8.data.dao.UserDao
import cc.jianminhuang.day8.data.dto.UserDto
import cc.jianminhuang.day8.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userDao: UserDao
): UserService {

    override fun addUser(userDto: UserDto) = userDao.save(userDto.toDo()).toDto()

    override fun queryUserById(id: Long) =
        userDao.findById(id)
            .map { it.toDto() }
            .orElseThrow { RuntimeException() }

    override fun modifyUser(userDto: UserDto) =
        userDao.findById(userDto.id!!)
            .orElseThrow { RuntimeException() }
            .run {
                this.firstName = userDto.name.split(",")[0].trim()
                this.lastName = userDto.name.split(",")[1].trim()
                this.age = userDto.age
                userDao.save(this).toDto()
            }

    override fun removeUserById(id: Long) = userDao.deleteById(id)
}