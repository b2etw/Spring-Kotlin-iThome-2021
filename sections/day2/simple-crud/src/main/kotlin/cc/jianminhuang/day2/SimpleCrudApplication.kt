package cc.jianminhuang.day2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleCrudApplication

fun main(args: Array<String>) {
    runApplication<SimpleCrudApplication>(*args)
}
