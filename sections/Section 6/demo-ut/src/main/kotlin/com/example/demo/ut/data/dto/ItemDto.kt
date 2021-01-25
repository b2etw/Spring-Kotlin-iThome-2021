package com.example.demo.ut.data.dto

import com.example.demo.ut.data.entity.Item

data class ItemDto(
    val id: Long,
    val name: String,
    val priceTwd: Float,
) {
    fun toEntity() = Item(null, name, priceTwd / 30)
}
