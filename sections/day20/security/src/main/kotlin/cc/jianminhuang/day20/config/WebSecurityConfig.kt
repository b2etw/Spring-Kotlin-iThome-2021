package cc.jianminhuang.day20.config

import cc.jianminhuang.day20.web.security.JwtRequestFilter
import cc.jianminhuang.day20.web.security.CustomUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@EnableJpaAuditing(auditorAwareRef = "auditorAwareRef", dateTimeProviderRef = "dateTimeAwareRef")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
class WebSecurityConfig(
    val jwtRequestFilter: JwtRequestFilter,
    val userDetailsService: CustomUserDetailsService
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/auth").permitAll()
//            .antMatchers(HttpMethod.POST, "/members/**").hasRole("ADMIN")
//            .antMatchers(HttpMethod.GET, "/members/**").hasAnyRole("ADMIN", "OP")
//            .antMatchers(HttpMethod.PUT, "/members/**").hasRole("ADMIN")
//            .antMatchers(HttpMethod.DELETE, "/members/**").hasRole("ADMIN")
            .anyRequest().authenticated()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}