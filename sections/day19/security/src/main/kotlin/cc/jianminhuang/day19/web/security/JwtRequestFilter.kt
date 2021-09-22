package cc.jianminhuang.day19.web.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class JwtRequestFilter(
    val jwtTokenService: JwtTokenService,
    val jwtUserDetailService: JwtUserDetailService
): OncePerRequestFilter() {

    private val AUTH_HEADER = "Authorization"
    private val AUTH_HEADER_START_WITH = "Bearer "

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val tokenInHeader = request.getHeader(AUTH_HEADER)

        if (tokenInHeader.startsWith(AUTH_HEADER_START_WITH)) {
            val token = tokenInHeader.substring(7)
            val account: String = jwtTokenService.retrieveSubject(token)
            if (null == SecurityContextHolder.getContext().authentication) {
                val userDetails: UserDetails = jwtUserDetailService.loadUserByUsername(account)
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }

        filterChain.doFilter(request, response)
    }
}