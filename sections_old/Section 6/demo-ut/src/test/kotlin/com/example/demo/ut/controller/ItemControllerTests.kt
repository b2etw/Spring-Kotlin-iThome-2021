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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
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
        val itemDtoParam = ItemDto(-1, "soccer", 30.0f)
        val itemDtoRtn = ItemDto(1, "soccer", 30.0f)
        given(itemService.addItem(itemDtoParam)).willReturn(itemDtoRtn)

        mockMvc.perform(
            post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(itemDtoParam))
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(objectMapper.writeValueAsString(itemDtoRtn)))
    }

    @Test
    internal fun `test query item by id`() {
        val itemDto = ItemDto(1L, "soccer", 30.0f)
        given(itemService.queryItemById(1)).willReturn(itemDto)

        mockMvc.perform(
            get("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(objectMapper.writeValueAsString(itemDto)))
    }

    @Test
    internal fun `test modify item`() {
        val itemDto = ItemDto(1, "basketball", 60.0f)
        given(itemService.modifyItem(itemDto)).willReturn(itemDto)

        mockMvc.perform(
            put("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(itemDto))
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(objectMapper.writeValueAsString(itemDto)))
    }

    @Test
    internal fun `test remove item by id`() {
        mockMvc.perform(
            delete("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
        )
            .andDo(print())
            .andExpect(status().isOk)
    }
}