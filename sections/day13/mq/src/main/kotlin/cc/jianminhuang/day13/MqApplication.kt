package cc.jianminhuang.day13

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class MqApplication

fun main(args: Array<String>) {
    runApplication<MqApplication>(*args)
}
