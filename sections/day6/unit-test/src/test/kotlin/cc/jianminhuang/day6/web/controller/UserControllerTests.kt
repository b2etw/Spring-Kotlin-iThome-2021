package cc.jianminhuang.day6.web.controller

import cc.jianminhuang.day6.data.dto.UserDto
import cc.jianminhuang.day6.service.impl.UserServiceImpl
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(UserController::class)
class UserControllerTests {

    @MockBean
    lateinit var userService: UserServiceImpl

    @Autowired
    lateinit var mockMvc: MockMvc

    private val objectMapper = ObjectMapper()

    @Test
    internal fun testAddUser() {
        val userDto = UserDto(null, "Vincent, Huang", 18)
        BDDMockito.given(userService.addUser(userDto)).willReturn(userDto.copy(id=1))

        mockMvc.perform(
            post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto))
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(objectMapper.writeValueAsString(userDto.copy(id=1))))
    }
}