package cc.jianminhuang.day14.data.dto

import java.time.LocalDateTime

data class UserDto(

    val id: Long?,

    val name: String,

    val age: Int,

    val eId: String,

    val onBroadDate: LocalDateTime,
)
