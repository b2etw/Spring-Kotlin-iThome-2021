package cc.jianminhuang.day4.web.controller

import cc.jianminhuang.day4.data.dto.UserDto
import cc.jianminhuang.day4.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @PostMapping
    fun addUser(req: HttpServletRequest, @RequestBody userDto: UserDto) = userService.addUser(userDto)

    @GetMapping("/{id}")
    fun queryUserById(@PathVariable id: Long) = userService.queryUserById(id)

    @PutMapping
    fun modifyUser(@RequestBody userDto: UserDto) = userService.modifyUser(userDto)

    @PatchMapping("/age")
    fun modifyUserWithAge(@RequestBody userDto: UserDto) = userService.modifyUserWithAge(userDto)

    @DeleteMapping("/{id}")
    fun removeUserById(@PathVariable id: Long) = userService.removeUserById(id)
}