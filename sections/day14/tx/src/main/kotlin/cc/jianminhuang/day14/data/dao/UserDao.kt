package cc.jianminhuang.day14.data.dao

import cc.jianminhuang.day14.data.`do`.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UserDao : JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}