package cc.jianminhuang.day19.web.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class JwtRequestFilter(
    val jwtTokenService: JwtTokenService,
    val customUserDetailsService: UserDetailsService
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val tokenInHeader = request.getHeader("Authorization")

        if (null != tokenInHeader && tokenInHeader.startsWith("Bearer ")) {
            val account = jwtTokenService.retrieveSubject(tokenInHeader.substring(7))
            if (null == SecurityContextHolder.getContext().authentication) {
                val userDetails = customUserDetailsService.loadUserByUsername(account)
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }

        filterChain.doFilter(request, response)
    }
}