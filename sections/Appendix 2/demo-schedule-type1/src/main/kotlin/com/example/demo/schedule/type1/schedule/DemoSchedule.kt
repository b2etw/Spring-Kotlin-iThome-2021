package com.example.demo.schedule.type1.schedule

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class DemoSchedule {

    private val logger = LoggerFactory.getLogger(this.javaClass)

//    @Scheduled(cron = "*/5 * * * * *")
//    fun printHello() = logger.info("Hello")

//    @Scheduled(cron = "*/5 * * * * *")
//    fun printHelloSleep() =
//        run {
//            logger.info("sleep")
//            TimeUnit.SECONDS.sleep(6)
//        }

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    fun printSleepAndWakeup() =
        run {
            logger.info("sleep")
            TimeUnit.SECONDS.sleep(6)
            logger.info("wakeup")
        }
}