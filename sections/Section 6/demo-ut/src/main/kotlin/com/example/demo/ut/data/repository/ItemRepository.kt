package com.example.demo.ut.data.repository

import com.example.demo.ut.data.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ItemRepository : JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
}