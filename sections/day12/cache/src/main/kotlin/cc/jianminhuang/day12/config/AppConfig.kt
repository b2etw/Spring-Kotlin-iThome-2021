package cc.jianminhuang.day12.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate

@Configuration
class AppConfig {

    @Bean
    fun stringRedisTemplate(redisConnectionFactory: RedisConnectionFactory) =
        StringRedisTemplate(redisConnectionFactory)

}