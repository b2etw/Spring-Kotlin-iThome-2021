package cc.jianminhuang.day18

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoroutineApplication

fun main(args: Array<String>) {
    runApplication<CoroutineApplication>(*args)
}
