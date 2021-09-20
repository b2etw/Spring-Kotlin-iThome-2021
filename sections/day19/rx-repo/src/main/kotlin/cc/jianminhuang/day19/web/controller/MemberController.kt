package cc.jianminhuang.day19.web.controller

import cc.jianminhuang.day19.data.`do`.Member
import cc.jianminhuang.day19.data.dao.MemberDao
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    val memberDao: MemberDao
) {

    @PostMapping
    suspend fun addMember(@RequestBody member: Member) = memberDao.save(member).awaitSingle()

    @GetMapping("/{id}")
    suspend fun queryMemberById(@PathVariable id: Long) = memberDao.findById(id).awaitSingle()
}