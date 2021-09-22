package cc.jianminhuang.day19.web.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenService {

    private val ISSUER = "jianminhuang.cc"
    private val EXPIRATION_MS = 30 * 60 * 1000
    private val SECRET = "ajfojefoijeoifjeiojfoiejfoijeoifjeiofjeoifauiwbgowerogfiajfojefoijeoifjeiojfoiejfoijeoifjeiofjeoifauiwbgowerogfi"

    fun generate(subject: String): String {
        val currentTimeMillis = System.currentTimeMillis()
        return Jwts.builder()
            .setIssuer(ISSUER)
            .setSubject(subject)
            .setAudience(null)
            .setExpiration(Date(currentTimeMillis + EXPIRATION_MS))
            .setNotBefore(Date(currentTimeMillis))
            .setIssuedAt(Date(currentTimeMillis))
            .setId(null)
            .signWith(Keys.hmacShaKeyFor(SECRET.toByteArray()), SignatureAlgorithm.HS512)
            .compact()
    }

    fun retrieveSubject(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(SECRET.toByteArray()))
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }
}