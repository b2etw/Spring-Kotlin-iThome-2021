package cc.jianminhuang.day10.task

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class MySchedule {

    private val logger = LoggerFactory.getLogger(javaClass)

//    @Scheduled(cron = "*/5 * * * * *")
//    fun printHello() = run {
//        logger.info("Sleep 6 seconds")
//        TimeUnit.SECONDS.sleep(6);
//        logger.info("Wake up")
//    }

    @Async
    @Scheduled(cron = "*/5 * * * * *")
    fun printHelloAsync() = run {
        logger.info("Sleep 6 seconds")
        TimeUnit.SECONDS.sleep(6);
        logger.info("Wake up")
    }
}