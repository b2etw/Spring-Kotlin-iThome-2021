package cc.jianminhuang.day5.web.controller

import cc.jianminhuang.day5.data.dto.UserDto
import cc.jianminhuang.day5.data.vo.UserVo
import cc.jianminhuang.day5.service.UserService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @PostMapping
    fun addUser(@RequestBody userDto: UserDto) = userService.addUser(userDto)

    @GetMapping("/{id}")
    fun queryUserById(@PathVariable id: Long) = userService.queryUserById(id)

    @GetMapping("/firstName/{firstName}")
    fun queryUserByFirstName(@PathVariable firstName: String) = userService.queryUserByFirstName(firstName)

    @GetMapping
    fun queryUerByLastName(
        @RequestParam lastName: String,
        @RequestParam page: Int,
        @RequestParam size:Int,
        @RequestParam column: String,
        @RequestParam direction: Sort.Direction,
    ) = userService.queryUserByLastName(lastName, PageRequest.of(page, size, direction, column))

    @PutMapping
    fun modifyUser(@RequestBody userDto: UserDto) = userService.modifyUser(userDto)

    @PatchMapping
    fun modifyUserAgeById(@RequestBody userVo: UserVo) = userService.modifyUserAgeById(userVo.age, userVo.id)

    @DeleteMapping("/{id}")
    fun removeUserById(@PathVariable id: Long) = userService.removeUserById(id)
}