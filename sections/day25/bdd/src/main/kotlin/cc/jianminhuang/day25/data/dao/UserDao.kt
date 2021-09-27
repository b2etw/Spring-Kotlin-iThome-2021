package cc.jianminhuang.day25.data.dao

import cc.jianminhuang.day25.data.`do`.User
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.Optional

interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findByFirstName(firstName: String, pageable: Pageable): List<User>

    fun findByPhone(phone: String): Optional<User>
}
