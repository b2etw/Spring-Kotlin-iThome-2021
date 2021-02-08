package com.example.demo.schedule

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class DemoTask {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Scheduled(cron = "*/5 * * * * *")
    fun helloTask() = run {
        logger.info("say hello")
        TimeUnit.SECONDS.sleep(6)
    }

    @Scheduled(cron = "*/5 * * * * *")
    fun helloTask2() = run {
        logger.info("say hello2")
        TimeUnit.SECONDS.sleep(3)
    }
}