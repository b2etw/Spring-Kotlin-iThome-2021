package cc.jianminhuang.day5.service.impl

import cc.jianminhuang.day5.data.dao.UserDao
import cc.jianminhuang.day5.data.dto.UserDto
import cc.jianminhuang.day5.service.UserService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserServiceImpl(
    val userDao: UserDao
): UserService {

    override fun addUser(userDto: UserDto) = userDao.save(userDto.toDo()).toDto()

    override fun queryUserById(id: Long) =
        userDao.findById(id)
            .map { it.toDto() }
            .orElseThrow { RuntimeException() }

    override fun queryUserByFirstName(firstName: String) =
        userDao.findByFirstNameOrderByIdDesc(firstName)
            .map { it.toDto() }

    override fun queryUserByLastName(lastName: String, pageable: Pageable) =
        userDao.findByLastName(lastName, pageable)
            .map { it.toDto() }

    override fun modifyUser(userDto: UserDto) =
        userDao.findById(userDto.id!!)
            .orElseThrow { RuntimeException() }
            .run {
                this.firstName = userDto.name.split(",")[0].trim()
                this.lastName = userDto.name.split(",")[1].trim()
                this.age = userDto.age
                userDao.save(this).toDto()
            }

    @Transactional
    override fun modifyUserAgeById(age: Int, id: Long) = userDao.updateUserAgeById(age, id)

    override fun removeUserById(id: Long) = userDao.deleteById(id)
}