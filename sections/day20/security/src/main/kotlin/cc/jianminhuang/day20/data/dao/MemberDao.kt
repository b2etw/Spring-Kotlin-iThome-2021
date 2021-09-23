package cc.jianminhuang.day20.data.dao

import cc.jianminhuang.day20.data.`do`.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.Optional

interface MemberDao: JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

    fun findByUid(uid: String): Optional<Member>
}