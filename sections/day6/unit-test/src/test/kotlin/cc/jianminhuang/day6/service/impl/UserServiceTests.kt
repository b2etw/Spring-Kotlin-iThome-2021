package cc.jianminhuang.day6.service.impl

import cc.jianminhuang.day6.data.dao.UserDao
import cc.jianminhuang.day6.data.dto.UserDto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito.mock
import java.util.Optional

class UserServiceTests {

    private val userDao = mock(UserDao::class.java)

    private val userService = UserServiceImpl(userDao)

    @Test
    internal fun testAddUser() {
        // arrange
        val userDto = UserDto(null, "Vincent, Huang", 18)
        val user = userDto.toDo()
        BDDMockito.given(userDao.save(user)).willReturn(user.copy(1))

        // act
        val addUser = userService.addUser(userDto)

        // assert
        Assertions.assertThat(addUser.id).isNotNull
        Assertions.assertThat(addUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(addUser.age).isEqualTo(18)
    }

    @Test
    internal fun testModifyUser() {
        val userDtoOrigin = UserDto(1, "Vincent, Huang", 18)
        val userOrigin = userDtoOrigin.toDo()
        BDDMockito.given(userDao.findById(1)).willReturn(
            Optional.of(userOrigin)
        )

        val userDto = UserDto(1, "Vincent, Huang", 20)
        val user = userDto.toDo()
        BDDMockito.given(userDao.save(user)).willReturn(user)

        val modifyUser = userService.modifyUser(userDto)

        Assertions.assertThat(modifyUser.id).isEqualTo(1)
        Assertions.assertThat(modifyUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(modifyUser.age).isEqualTo(20)
    }
}