package com.example.demo.data.repository

import com.example.demo.data.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface ItemRepository : JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    @Query("UPDATE Item i SET i.price = 100 WHERE i.name = :name")
    @Modifying
    @Transactional
    fun updateSoccer(@Param("name") name: String)

    @Query("DELETE FROM Item i WHERE i.name = :name")
    @Modifying
    @Transactional
    fun deleteSoccer(@Param("name") name: String): Int
}