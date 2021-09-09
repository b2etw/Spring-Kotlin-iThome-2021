package cc.jianminhuang.day8.web.controller

import cc.jianminhuang.day8.data.dto.UserDto
import cc.jianminhuang.day8.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "User Related")
@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @Operation(summary = "Add User", description = "Add User via UserDto")
    @ApiResponse(responseCode = "400", description = "Wrong Parameter")
    @PostMapping
    fun addUser(@RequestBody userDto: UserDto) = userService.addUser(userDto)

    @GetMapping("/{id}")
    fun queryUserById(@PathVariable id: Long) = userService.queryUserById(id)

    @PutMapping
    fun modifyUser(@RequestBody userDto: UserDto) = userService.modifyUser(userDto)

    @DeleteMapping("/{id}")
    fun removeUserById(@PathVariable id: Long) = userService.removeUserById(id)
}