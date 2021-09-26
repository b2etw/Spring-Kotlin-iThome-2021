package cc.jianminhuang.day23.web.controller

import cc.jianminhuang.day23.data.dto.UserDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTests(
    @LocalServerPort port: Int
) {

    private val webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:$port").build()

    private val objectMapper = ObjectMapper()

    @Test
    internal fun testUser() {
        val userDto = UserDto(null, "Ken, Ho", 15)

        val post = webTestClient.post().uri("/users").bodyValue(userDto).exchange()
        post.expectStatus().isOk
        post.expectBody().json(objectMapper.writeValueAsString(userDto.copy(id=4)))

        val get = webTestClient.get().uri("/users/1").exchange()
        get.expectStatus().isOk
        get.expectBody().json(objectMapper.writeValueAsString(UserDto(1, "Vincent, Huang", 17)))

        val put = webTestClient.put().uri("/users").bodyValue(userDto.copy(id=4, age = 20)).exchange()
        put.expectStatus().isOk
        put.expectBody().json(objectMapper.writeValueAsString(userDto.copy(id=4, age = 20)))

        val delete = webTestClient.delete().uri("/users/1").exchange()
        delete.expectStatus().isOk
    }
}