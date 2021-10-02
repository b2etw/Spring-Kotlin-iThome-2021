package cc.jianminhuang.day25.service.impl

import cc.jianminhuang.day25.data.`do`.User
import cc.jianminhuang.day25.data.dao.UserDao
import cc.jianminhuang.day25.service.UserService
import org.springframework.data.domain.PageRequest

class UserServiceImpl(
    val userDao: UserDao
) : UserService {

    override fun query(pageRequest: PageRequest) = userDao.findAll()

    override fun queryById(id: Long) = userDao.findById(id).orElseThrow { RuntimeException() }

    override fun findByFirstName(firstName: String, pageRequest: PageRequest) = userDao.findByFirstName(firstName, pageRequest)

    override fun findByPhone(phone: String) = userDao.findByPhone(phone).orElseThrow { RuntimeException() }

    override fun add(user: User) = userDao.save(user)

    override fun modifyAgeById(age: Int, id: Long) =
        userDao.findById(id)
            .orElseThrow { RuntimeException() }
            .run {
                this.age = age
                userDao.save(this)
            }

    override fun removeById(id: Long) = userDao.deleteById(id)

}
