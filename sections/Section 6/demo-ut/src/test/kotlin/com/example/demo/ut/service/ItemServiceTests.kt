package com.example.demo.ut.service

import com.example.demo.ut.data.dto.ItemDto
import com.example.demo.ut.data.entity.Item
import com.example.demo.ut.data.repository.ItemRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.Optional

@SpringBootTest
class ItemServiceTests {

    @MockBean
    private lateinit var itemRepository: ItemRepository

    @Autowired
    private lateinit var itemService: ItemService

    @Test
    internal fun `test add item`() {
        // arrange
        given(itemRepository.save(Item(null, "soccer", 1.0f))).willReturn(Item(1, "soccer", 1.0f))
        val itemDto = ItemDto(-1, "soccer", 30.0f)

        // act
        val addItem = itemService.addItem(itemDto)

        // assert
        Assertions.assertThat(addItem.id).isNotNull
        Assertions.assertThat(addItem.name).isEqualTo("soccer")
        Assertions.assertThat(addItem.priceTwd).isEqualTo(30.0f)
    }

    @Test
    internal fun `test query item by id`() {
        given(itemRepository.findById(1)).willReturn(Optional.of(Item(1, "soccer", 1.0f)))

        val queryItem = itemService.queryItemById(1)

        Assertions.assertThat(queryItem.id).isEqualTo(1)
        Assertions.assertThat(queryItem.name).isEqualTo("soccer")
        Assertions.assertThat(queryItem.priceTwd).isEqualTo(30.0f)
    }

    @Test
    internal fun `test modify item`() {
        val item = Item(1, "soccer", 1.0f)
        given(itemRepository.findById(1)).willReturn(Optional.of(item))
        item.name = "basketball"
        item.priceUsd = 2.0f
        given(itemRepository.save(item)).willReturn(item)

        val itemDto = ItemDto(1, "basketball", 60.0f)

        val modifyItem = itemService.modifyItem(itemDto)

        Assertions.assertThat(modifyItem.id).isEqualTo(1)
        Assertions.assertThat(modifyItem.name).isEqualTo("basketball")
        Assertions.assertThat(modifyItem.priceTwd).isEqualTo(60.0f)
    }

    @Test
    internal fun `test remove item by id`() {
        itemService.removeItemById(1)

        verify(itemRepository).deleteById(1)
    }
}