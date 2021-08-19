package com.example.demo.doc.data.dto

import io.swagger.v3.oas.annotations.media.Schema

data class UserDto(

    @Schema(description = "the id of user", example = "1")
    val id: Long,

    @Schema(description = "the first name of user", example = "Vincent")
    val firstName: String,

    @Schema(description = "the last name of user", example = "Huang")
    val lastName: String,

    @Schema(description = "the age of user", example = "88")
    val age: Int,
)

