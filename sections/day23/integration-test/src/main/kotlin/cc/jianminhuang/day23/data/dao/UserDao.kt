package cc.jianminhuang.day23.data.dao

import cc.jianminhuang.day23.data.`do`.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}