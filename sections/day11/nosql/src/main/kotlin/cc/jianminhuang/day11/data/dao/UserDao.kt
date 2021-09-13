package cc.jianminhuang.day11.data.dao

import cc.jianminhuang.day11.data.`do`.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserDao : MongoRepository<User, ObjectId> {

    fun findByAge(age: Int): List<User>
}