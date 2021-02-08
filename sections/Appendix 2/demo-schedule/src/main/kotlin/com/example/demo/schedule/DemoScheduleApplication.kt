package com.example.demo.schedule

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@EnableAsync
@EnableScheduling
@SpringBootApplication
class DemoScheduleApplication

fun main(args: Array<String>) {
    runApplication<DemoScheduleApplication>(*args)
}
