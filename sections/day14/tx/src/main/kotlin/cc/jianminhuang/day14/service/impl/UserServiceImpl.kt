package cc.jianminhuang.day14.service.impl

import cc.jianminhuang.day14.data.`do`.Employee
import cc.jianminhuang.day14.data.`do`.User
import cc.jianminhuang.day14.data.dao.EmployeeDao
import cc.jianminhuang.day14.data.dao.UserDao
import cc.jianminhuang.day14.data.dto.UserDto
import cc.jianminhuang.day14.service.UserService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class UserServiceImpl(
    val userDao: UserDao,
    val employeeDao: EmployeeDao,
): UserService {

    @Transactional(rollbackOn = [Exception::class])
    override fun addUser(user: User) = run {
        val savedUser = userDao.save(user)

        val saveEmployee = employeeDao.save(Employee(null, savedUser.id!!, savedUser.firstName!!, LocalDateTime.now()))

        UserDto(savedUser.id, savedUser.firstName + ", " + savedUser.lastName, savedUser.age, "B0" + saveEmployee.id!!, saveEmployee.onBroadDate)
    }

    private fun xxx() = run {
        addUser()
    }
}