package cc.jianminhuang.day9.data.dao

import cc.jianminhuang.day9.data.`do`.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findByAge(age: Int): List<User>
}