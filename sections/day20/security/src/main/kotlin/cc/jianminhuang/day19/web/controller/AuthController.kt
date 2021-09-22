package cc.jianminhuang.day19.web.controller

import cc.jianminhuang.day19.data.dto.AuthReq
import cc.jianminhuang.day19.web.security.JwtTokenService
import cc.jianminhuang.day19.web.security.CustomUserDetailsService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class AuthController(
    val authenticationManager: AuthenticationManager,
    val jwtTokenService: JwtTokenService,
    val jwtCustomUserDetailsService: CustomUserDetailsService,
) {

    @PostMapping("/auth")
    fun auth(@RequestBody authReq: AuthReq) = run {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(authReq.userName, authReq.password))
        val userDetails = jwtCustomUserDetailsService.loadUserByUsername(authReq.userName)
        jwtTokenService.generate(UUID.randomUUID().toString(), userDetails.username)
    }
}