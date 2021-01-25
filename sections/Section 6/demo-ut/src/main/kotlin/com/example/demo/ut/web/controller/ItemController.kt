package com.example.demo.ut.web.controller

import com.example.demo.ut.data.dto.ItemDto
import com.example.demo.ut.service.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(
    val itemService: ItemService
) {

    @PostMapping
    fun addItem(@RequestBody itemDto: ItemDto) = ResponseEntity.ok(itemService.addItem(itemDto))

    @GetMapping
    fun queryItemById(@RequestParam id: Long) = ResponseEntity.ok(itemService.queryItemById(id))

    @PutMapping
    fun modifyItem(@RequestBody itemDto: ItemDto) = ResponseEntity.ok(itemService.modifyItem(itemDto))

    @DeleteMapping
    fun removeItemById(@RequestParam id: Long) = ResponseEntity.ok(itemService.removeItemById(id))
}