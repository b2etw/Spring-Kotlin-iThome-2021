package com.example.demo.data.dto

import com.example.demo.data.enu.OrderStatus
import java.time.LocalDateTime
import java.time.OffsetDateTime

data class OrderDto(

    val id: String,

    var itemName: String,

    var amount: Int,

    var totalPrice: Double,

    var status: OrderStatus,

    var orderTime: LocalDateTime,

    var utcOrderTime: OffsetDateTime
)
