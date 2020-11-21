package com.example.demo.data.dto

import com.example.demo.data.entity.User

data class UserDto(

        val id: Long,

        val name: String,

        val age: Int
) {
    fun trans2Entity() = User(this.id, this.name.split(",")[0].trim(), this.name.split(",")[1].trim(), this.age)
}