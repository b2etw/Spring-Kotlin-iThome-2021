package cc.jianminhuang.day12.data.dao

import cc.jianminhuang.day12.data.`do`.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}