package cc.jianminhuang.day19

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
class SecurityApplication

fun main(args: Array<String>) {
	runApplication<SecurityApplication>(*args)
}
