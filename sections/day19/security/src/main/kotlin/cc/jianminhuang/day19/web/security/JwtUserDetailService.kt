package cc.jianminhuang.day19.web.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class JwtUserDetailService: UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}

fun main() {
    println(BCryptPasswordEncoder().encode("1234"))
}