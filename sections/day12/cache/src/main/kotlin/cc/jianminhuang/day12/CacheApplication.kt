package cc.jianminhuang.day12

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class CacheApplication

fun main(args: Array<String>) {
    runApplication<CacheApplication>(*args)
}
