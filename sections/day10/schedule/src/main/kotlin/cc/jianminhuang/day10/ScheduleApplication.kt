package cc.jianminhuang.day10

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@EnableAsync
@EnableScheduling
@SpringBootApplication
class ScheduleApplication

fun main(args: Array<String>) {
    runApplication<ScheduleApplication>(*args)
}
