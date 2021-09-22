package cc.jianminhuang.day19.web.controller

import cc.jianminhuang.day19.data.`do`.Member
import cc.jianminhuang.day19.data.dao.MemberDao
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    val memberDao: MemberDao
) {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    fun addMember(@RequestBody member: Member) = memberDao.save(member)
}