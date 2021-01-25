package com.example.demo.ut.controller

import com.example.demo.ut.data.dto.ItemDto
import com.example.demo.ut.service.ItemService
import com.example.demo.ut.web.controller.ItemController
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ItemController::class)
class ItemControllerTests {

    @MockBean
    private lateinit var itemService: ItemService

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val objectMapper = jacksonObjectMapper()

    @Test
    internal fun `test add item`() {
        given(itemService.addItem(ItemDto(-1, "soccer", 30.0f))).willReturn(ItemDto(1, "soccer", 30.0f))

        mockMvc.perform(
            post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(ItemDto(-1, "soccer", 30.0f)))
        )
            .andExpect(status().isOk)
            .andExpect(content().string(objectMapper.writeValueAsString(ItemDto(1, "soccer", 30.0f))))
    }

    @Test
    internal fun `test query item by id`() {
        TODO("Not yet implemented")
    }

    @Test
    internal fun `test modify item`() {
        TODO("Not yet implemented")
    }

    @Test
    internal fun `test remove item by id`() {
        TODO("Not yet implemented")
    }
}