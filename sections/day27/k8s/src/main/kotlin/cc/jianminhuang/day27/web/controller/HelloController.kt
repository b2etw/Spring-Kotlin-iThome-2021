package cc.jianminhuang.day27.web.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Value("\${custom.name}")
    private lateinit var customName: String

    @GetMapping("/hello/{name}")
    fun sayHello(@PathVariable name: String) = "Hello, $customName and $name"
}