package com.example.demo.controller

import com.example.demo.data.dto.OrderDto
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
    fun get(@RequestParam("id") id: String): ResponseEntity<Orderz> {
        return ResponseEntity.ok(orderzRepository.findById(id).orElseThrow { RuntimeException() })
    }
    @GetMapping("/full/orders")
    fun getFull(@RequestParam("id") id: String): ResponseEntity<OrderDto> {
        return ResponseEntity.ok(orderzRepository.findFullOrderByIAd(id))
    }

    @PostMapping("/orders")
    fun post() : ResponseEntity<String> {
        val item = Item(null, 10.0f, "soccer")
        val saveItem = itemRepository.save(item)

        val order = Orderz(null, saveItem.id!!, 1, 1* item.price.toDouble(), OrderStatus.INITIAL, LocalDateTime.now(), OffsetDateTime.now(ZoneOffset.UTC))
        val save = orderzRepository.save(order)

        return ResponseEntity.ok("Success")
    }

    @PutMapping("/orders")
    fun put(): ResponseEntity<String> {
        itemRepository.updateSoccer("soccer")

        return ResponseEntity.ok("Success")
    }

    @DeleteMapping("/orders")
    fun delete(): ResponseEntity<String> {
        val deleteSoccerCount = itemRepository.deleteSoccer("soccer")
        return ResponseEntity.ok(deleteSoccerCount.toString())
    }
}