package cc.jianminhuang.day8.web.controller

import cc.jianminhuang.day8.data.dto.UserDto
import cc.jianminhuang.day8.ext.Logging
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

class UserControllerTests : Logging {

    private val webClient = WebClient.builder().build()

    @Test
    internal fun testAddUser() {

        val addUser = webClient.post()
            .uri("http://localhost:8080/api-doc/users")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(UserDto(null, "Vincent, Huang", 18))
            .retrieve()
            .bodyToMono(UserDto::class.java)
            .block()

        logger().info("{}", addUser)
    }

    @Test
    internal fun testQueryUserById() {
        val userDto = webClient.get()
            .uri("http://localhost:8080/api-doc/users/3")
            .retrieve()
            .bodyToMono(UserDto::class.java)
            .block()

        logger().info("{}", userDto)
    }
}