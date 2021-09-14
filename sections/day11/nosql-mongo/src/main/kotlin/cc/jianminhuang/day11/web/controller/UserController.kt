package cc.jianminhuang.day11.web.controller

import cc.jianminhuang.day11.data.`do`.User
import cc.jianminhuang.day11.data.dao.UserDao
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
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
    val userDao: UserDao
) {

    @PostMapping
    fun addUser(@RequestBody user: User) = userDao.save(user)

    @GetMapping("/{id}")
    fun queryUserById(@PathVariable id: String) = userDao.findById(id).orElseThrow { RuntimeException() }

    @GetMapping
    fun queryUserByAge(@RequestParam age: Int) = userDao.findByAge(age)

    @PutMapping
    fun modifyUser(@RequestBody user: User) = userDao.findById(user.id!!)
        .orElseThrow { RuntimeException() }
        .run {
            this.firstName = user.firstName
            this.lastName = user.lastName
            this.age = user.age
            userDao.save(this)
        }

    @DeleteMapping("/{id}")
    fun removeUserById(@PathVariable id: String) = userDao.deleteById(id)
}