package com.example.demo.nosql.data.entity

import com.example.demo.nosql.data.dto.UserDto
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User(

    @Id
    val id: ObjectId,

    var firstName: String,

    var lastName: String,

    var age: Int,
) {
    fun toDto() =
        UserDto(
            this.id.toString(),
            "${this.firstName}, ${this.lastName}",
            this.age,
        )
}
