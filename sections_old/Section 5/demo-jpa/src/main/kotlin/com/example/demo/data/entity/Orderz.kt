package com.example.demo.data.entity

import com.example.demo.data.enu.OrderStatus
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class Orderz(

    @Id
    @GeneratedValue(generator = "default-uuid")
    @GenericGenerator(name = "default-uuid", strategy = "uuid2")
    val id: String?,

    @Column
    var itemId: Long,

    @Column
    var amount: Int,

    @Column
    var totalPrice: Double,

    @Column
    @Enumerated(EnumType.STRING)
    var status: OrderStatus,

    @Column
    var orderTime: LocalDateTime,

    @Column
    var utcOrderTime: OffsetDateTime
)