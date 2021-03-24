package com.example.demo.schedule.type1.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
class AsyncConfig {

    @Bean
    fun taskExecutor() = run {
        val threadPoolTaskExecutor = ThreadPoolTaskExecutor()
        threadPoolTaskExecutor.corePoolSize = 2
        threadPoolTaskExecutor.maxPoolSize = 2
        threadPoolTaskExecutor.setQueueCapacity(100)
        threadPoolTaskExecutor.setThreadNamePrefix("demo")
        threadPoolTaskExecutor.initialize()
        threadPoolTaskExecutor
    }
}