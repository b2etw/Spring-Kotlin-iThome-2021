package cc.jianminhuang.day25.service

import cc.jianminhuang.day25.data.`do`.User
import org.springframework.data.domain.PageRequest

interface UserService {

    fun query(pageRequest: PageRequest): List<User>

    fun queryById(id: Long): User

    fun findByFirstName(firstName: String, pageRequest: PageRequest): List<User>

    fun findByPhone(phone: String): User

    fun add(user: User): User

    fun modifyAgeById(age: Int, id: Long): User

    fun removeById(id: Long)

}
