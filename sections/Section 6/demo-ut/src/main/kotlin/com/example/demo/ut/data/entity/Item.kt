package com.example.demo.ut.data.entity

import com.example.demo.ut.data.dto.ItemDto
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class Item(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var name: String,

    @Column
    var priceUsd: Float,
) {
    fun toDto() = ItemDto(id!!, name, priceUsd * 30)
}
