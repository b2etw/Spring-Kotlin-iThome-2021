package cc.jianminhuang.day20.web.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenService {

    private val ISSUER = "jianminhuang.cc"
    private val EXPIRATION_MS = 30 * 60 * 1000
    private val SECRET = "Spring-Kotlin-iThome-2021_Spring-Kotlin-iThome-2021_Spring-Kotlin-iThome-2021"

    fun generate(id: String, subject: String) = System.currentTimeMillis()
        .run {
            Jwts.builder()
                .setIssuer(ISSUER)
                .setSubject(subject)
                .setAudience(null)
                .setExpiration(Date(this + EXPIRATION_MS))
                .setNotBefore(Date(this))
                .setIssuedAt(Date(this))
                .setId(id)
                .signWith(Keys.hmacShaKeyFor(SECRET.toByteArray()), SignatureAlgorithm.HS512)
                .compact()
        }

    fun retrieveSubject(token: String) =
        Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(SECRET.toByteArray()))
            .build()
            .parseClaimsJws(token)
            .body
            .subject
}