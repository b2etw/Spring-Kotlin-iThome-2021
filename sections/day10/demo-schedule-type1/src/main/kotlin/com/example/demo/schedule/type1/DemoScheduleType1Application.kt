package com.example.demo.schedule.type1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@EnableAsync
@EnableScheduling
@SpringBootApplication
class DemoScheduleType1Application

fun main(args: Array<String>) {
    runApplication<DemoScheduleType1Application>(*args)
}
