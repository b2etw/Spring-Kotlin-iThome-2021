package com.example.demo.ut.service

import com.example.demo.ut.data.dto.ItemDto

interface ItemService {

    fun addItem(itemDto: ItemDto): ItemDto

    fun queryItemById(id: Long): ItemDto

    fun modifyItem(itemDto: ItemDto): ItemDto

    fun removeItemById(id: Long)
}