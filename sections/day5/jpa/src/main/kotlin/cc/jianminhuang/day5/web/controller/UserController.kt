package cc.jianminhuang.day5.web.controller

import cc.jianminhuang.day5.data.`do`.User
import cc.jianminhuang.day5.data.dao.UserDao
import cc.jianminhuang.day5.data.vo.UserVo
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional

@RestController
@RequestMapping("/users")
class UserController(
    val userDao: UserDao
) {

    @PostMapping
    fun addUser(@RequestBody user: User) = userDao.save(user)

    @GetMapping("/{age}")
    fun queryUserByAge(@PathVariable age: Int) = userDao.findByAgeOrderByIdDesc(age)

    @GetMapping
    fun queryUserByLastName(
        @RequestParam lastName: String,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @RequestParam column: String,
        @RequestParam direction: Sort.Direction
    ) = userDao.findByLastName(lastName, PageRequest.of(page, size, direction, column))

    @PatchMapping
    @Transactional
    fun modifyUserAgeById(@RequestBody userVo: UserVo) = userDao.updateAgeById(userVo.age, userVo.id)
}