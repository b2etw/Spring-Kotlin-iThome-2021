package com.example.demo.ut.service.impl

import com.example.demo.ut.data.dto.ItemDto
import com.example.demo.ut.data.repository.ItemRepository
import com.example.demo.ut.service.ItemService
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(
    val itemRepository: ItemRepository
) : ItemService {

    override fun addItem(itemDto: ItemDto) =
        itemDto.toEntity().run {
            itemRepository.save(this)
        }.run {
            this.toDto()
        }

    override fun queryItemById(id: Long) =
        itemRepository.findById(id).orElseThrow {
            RuntimeException()
        }.run {
            this.toDto()
        }

    override fun modifyItem(itemDto: ItemDto) =
        itemRepository.findById(itemDto.id).orElseThrow {
            RuntimeException()
        }.run {
            this.name = itemDto.name
            this.priceUsd = itemDto.priceTwd / 30
            itemRepository.save(this)
        }.run {
            this.toDto()
        }

    override fun removeItemById(id: Long) = itemRepository.deleteById(id)

}