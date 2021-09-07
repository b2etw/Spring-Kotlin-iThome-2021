package cc.jianminhuang.day5.data.dao

import cc.jianminhuang.day5.data.`do`.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findByAgeOrderByIdDesc(age: Int): List<User>

    fun findByLastName(lastName: String, pageable: Pageable): Page<User>

    @Modifying
    @Query("UPDATE User u SET u.age = :age WHERE u.id = :id")
    fun updateAgeById(age: Int, id: Long)
}