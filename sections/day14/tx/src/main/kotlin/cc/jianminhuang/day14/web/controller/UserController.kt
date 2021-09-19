package cc.jianminhuang.day14.web.controller

import cc.jianminhuang.day14.data.`do`.User
import cc.jianminhuang.day14.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService
) {

    @PostMapping("/users")
    fun addUser(@RequestBody user: User) = userService.addUser(user)
}