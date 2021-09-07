package cc.jianminhuang.day6.data.dao

import cc.jianminhuang.day6.data.`do`.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}