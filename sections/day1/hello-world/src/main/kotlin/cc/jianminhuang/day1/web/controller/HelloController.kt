package cc.jianminhuang.day1.web.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun sayHello(@RequestParam name: String) = "Hello $name"

    @GetMapping("/hello/{name}")
    fun sayHelloPath(@PathVariable name: String) = "Hello $name"
}