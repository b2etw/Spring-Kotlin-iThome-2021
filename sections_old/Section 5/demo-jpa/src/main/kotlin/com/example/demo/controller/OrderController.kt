package com.example.demo.controller

import com.example.demo.data.entity.Item
import com.example.demo.data.entity.Orderz
import com.example.demo.data.enu.OrderStatus
import com.example.demo.data.repository.ItemRepository
import com.example.demo.data.repository.OrderzRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

@RestController
class OrderController(
    val orderzRepository: OrderzRepository,
    val itemRepository: ItemRepository
) {

    @GetMapping("/orders")
    fun get(@RequestParam("id") id: String) = run {
        ResponseEntity.ok(orderzRepository.findById(id).orElseThrow { RuntimeException() })
    }

    @GetMapping("/full/orders")
    fun getFull(@RequestParam("id") id: String) = run {
        ResponseEntity.ok(orderzRepository.findFullOrderByIAd(id))
    }

    @PostMapping("/orders")
    fun post() = run {
        val item = Item(null, 10.0f, "soccer")
        itemRepository.save(item)
    }.run {
        val order = Orderz(
            null,
            this.id!!,
            1,
            1 * this.price.toDouble(),
            OrderStatus.INITIAL,
            LocalDateTime.now(),
            OffsetDateTime.now(ZoneOffset.UTC)
        )

        ResponseEntity.ok(orderzRepository.save(order))
    }

    @PutMapping("/orders")
    fun put() = run {
        ResponseEntity.ok(itemRepository.updateAllSoccerPrice(100.0f, "soccer"))
    }

    @DeleteMapping("/orders")
    fun delete() = run {
        ResponseEntity.ok(itemRepository.deleteAllSoccer("soccer"))
    }
}