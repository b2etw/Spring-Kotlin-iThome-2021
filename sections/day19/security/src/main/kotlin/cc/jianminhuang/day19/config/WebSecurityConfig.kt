package cc.jianminhuang.day19.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(null).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}