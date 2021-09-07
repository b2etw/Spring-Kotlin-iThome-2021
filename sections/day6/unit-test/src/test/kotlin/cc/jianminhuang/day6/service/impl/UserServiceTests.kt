package cc.jianminhuang.day6.service.impl

import cc.jianminhuang.day6.data.`do`.User
import cc.jianminhuang.day6.data.dao.UserDao
import cc.jianminhuang.day6.data.dto.UserDto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import java.util.Optional

class UserServiceTests {

    private val userDao = Mockito.mock(UserDao::class.java)

    private val userService = UserServiceImpl(userDao)

    @Test
    internal fun testAddUser() {
        // arrange
        val userDto = UserDto(null, "Vincent, Huang", 18)
        BDDMockito.given(
            userDao.save(User(null, "Vincent", "Huang", 18))
        ).willReturn(User(1L, "Vincent", "Huang", 18))

        // act
        val addUser = userService.addUser(userDto)

        // assert
        Assertions.assertThat(addUser.id).isNotNull
        Assertions.assertThat(addUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(addUser.age).isEqualTo(18)
    }

    @Test
    internal fun testQueryUserById() {
        val user = User(1L, "Vincent", "Huang", 18)
        BDDMockito.given(userDao.findById(1L)).willReturn(Optional.of(user))

        val queryUser = userService.queryUserById(1L)

        Assertions.assertThat(queryUser.id).isEqualTo(1L)
        Assertions.assertThat(queryUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(queryUser.age).isEqualTo(18)
    }

    @Test
    internal fun testModifyUser() {
        val userDto = UserDto(2L, "Wade, Wu", 30)
        BDDMockito.given(userDao.findById(2L)).willReturn(Optional.of(userDto.toDo()))
        BDDMockito.given(userDao.save(userDto.toDo())).willReturn(userDto.toDo())

        val modifyUser = userService.modifyUser(userDto)

        Assertions.assertThat(modifyUser.id).isEqualTo(2L)
        Assertions.assertThat(modifyUser.name).isEqualTo("Wade, Wu")
        Assertions.assertThat(modifyUser.age).isEqualTo(30)
    }
}