package cc.jianminhuang.day11.data.dao

import cc.jianminhuang.day11.data.`do`.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserDao : MongoRepository<User, String> {

    fun findByAge(age: Int): List<User>
}