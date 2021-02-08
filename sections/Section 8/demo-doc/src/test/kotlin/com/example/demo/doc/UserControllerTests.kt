package com.example.demo.doc

import com.example.demo.doc.data.dto.UserDto
import org.junit.jupiter.api.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

class UserControllerTests {

    private val restTemplate = RestTemplate()

    @Test
    internal fun testAddUser() {
        val getUser = restTemplate.getForEntity("http://localhost:8080/users?id=1", UserDto::class.java)
        println(getUser)

        val user = UserDto(1, "Vincent", "Huang", 88)
        val postUser = restTemplate.postForEntity("http://localhost:8080/users", user, UserDto::class.java)
        println(postUser)

        val putUser = restTemplate.exchange("http://localhost:8080/users", HttpMethod.PUT, HttpEntity(user), UserDto::class.java)
        println(putUser)

        restTemplate.exchange("http://localhost:8080/users?id=1", HttpMethod.DELETE, HttpEntity.EMPTY, Void::class.java)
    }
}