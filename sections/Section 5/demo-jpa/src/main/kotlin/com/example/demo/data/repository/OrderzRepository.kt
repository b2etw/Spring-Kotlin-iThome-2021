package com.example.demo.data.repository

import com.example.demo.data.dto.OrderDto
import com.example.demo.data.entity.Orderz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface OrderzRepository : JpaRepository<Orderz, String>, JpaSpecificationExecutor<Orderz> {

    @Query("SELECT " +
            "new com.example.demo.data.dto.OrderDto(o.id, i.name, o.amount, o.totalPrice, o.status, o.orderTime, o.utcOrderTime) " +
            "FROM Orderz o INNER JOIN Item i ON o.itemId = i.id " +
            "WHERE o.id = :id")
    fun findFullOrderByIAd(@Param("id") id: String) : OrderDto
}