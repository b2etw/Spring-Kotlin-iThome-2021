package cc.jianminhuang.day6.service

import cc.jianminhuang.day6.data.dao.UserDao
import cc.jianminhuang.day6.data.dto.UserDto
import cc.jianminhuang.day6.service.impl.UserServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito.mock

class UserServiceTests {

    private val userDao = mock(UserDao::class.java)

    private val userService = UserServiceImpl(userDao)

    @Test
    internal fun testAddUser() {
        // arrange
        val userDto = UserDto(null, "Vincent, Huang", 18)
        val userDo = userDto.toDo()
        BDDMockito.given(userDao.save(userDo)).willReturn(userDo.copy(id=1))

        // act
        val addUser = userService.addUser(userDto)

        // assert
        Assertions.assertThat(addUser.id).isNotNull
        Assertions.assertThat(addUser.name).isEqualTo("Vincent, Huang")
        Assertions.assertThat(addUser.age).isEqualTo(18)
    }
}