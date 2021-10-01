package cc.jianminhuang.day27

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class K8sApplication

fun main(args: Array<String>) {
    runApplication<K8sApplication>(*args)
}
