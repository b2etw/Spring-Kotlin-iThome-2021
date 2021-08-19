package com.example.demo.nosql.data.dto

import com.example.demo.nosql.data.entity.User
import org.bson.types.ObjectId

data class UserDto(

    val id: String,
    val name: String,
    val age: Int,
) {
    fun toEntity() =
        User(
            if (this.id.isEmpty()) ObjectId() else ObjectId(id),
            this.name.split(",")[0].trim(),
            this.name.split(",")[1].trim(),
            this.age
        )
}
