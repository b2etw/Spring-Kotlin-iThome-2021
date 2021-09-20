package cc.jianminhuang.day19.data.dao

import cc.jianminhuang.day19.data.`do`.Member
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MemberDao: ReactiveCrudRepository<Member, Long> {
}