package cc.jianminhuang.day19.web.security

import cc.jianminhuang.day19.data.dao.MemberDao
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    val memberDao: MemberDao
) : UserDetailsService {

    override fun loadUserByUsername(username: String) = memberDao.findByUid(username)
        .map { User(it.uid, it.password, listOf(SimpleGrantedAuthority(it.role))) }
        .orElseThrow { UsernameNotFoundException(username) }
}

fun main() {
    println(BCryptPasswordEncoder().encode("123456"))
}