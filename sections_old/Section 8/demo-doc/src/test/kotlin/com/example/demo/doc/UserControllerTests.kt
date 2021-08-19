package com.example.demo.doc

import com.example.demo.doc.data.dto.UserDto
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTests {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @LocalServerPort
    private var port = 0

    private val restTemplate = RestTemplate()

    @Test
    internal fun testAddUser() {
        val userDto = UserDto(-1, "Vincent", "Huang", 99)

        val postUser = restTemplate.postForEntity("http://localhost:$port/users", userDto, UserDto::class.java)
        log.info(postUser.toString())
    }

    @Test
    internal fun testQueryUserById() {
        val getUser = restTemplate.getForEntity("http://localhost:$port/users?id=1", UserDto::class.java)
        log.info(getUser.toString())
    }

    @Test
    internal fun testModifyUser() {
        val userDto = UserDto(1, "Daniel", "Liu", 33)

        val putUser = restTemplate.exchange(
            "http://localhost:$port/users",
            HttpMethod.PUT,
            HttpEntity(userDto),
            UserDto::class.java
        )
        log.info(putUser.toString())
    }

    @Test
    internal fun removeUserById() {
        restTemplate.exchange(
            "http://localhost:$port/users?id=1",
            HttpMethod.DELETE,
            HttpEntity.EMPTY,
            Void::class.java
        )
    }
}