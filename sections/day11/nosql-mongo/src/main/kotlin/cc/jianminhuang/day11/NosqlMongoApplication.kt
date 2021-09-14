package cc.jianminhuang.day11

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NosqlMongoApplication

fun main(args: Array<String>) {
    runApplication<NosqlMongoApplication>(*args)
}
