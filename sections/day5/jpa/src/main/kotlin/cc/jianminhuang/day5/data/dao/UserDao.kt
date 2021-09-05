package cc.jianminhuang.day5.data.dao

import cc.jianminhuang.day5.data.`do`.User
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface UserDao : JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findByAge(age: Int): List<User>

    fun findByLastName(lastName: String, pageable: Pageable): List<User>

    @Modifying
    @Query("UPDATE User u SET u.age = :age WHERE u.id = :id")
    fun updateAgeById(id: Long, age: Int)
}