package cc.jianminhuang.day6.data.dto

import cc.jianminhuang.day6.data.`do`.User

data class UserDto(

    val id: Long?,

    val name: String,

    val age: Int,
) {
    fun toDo() = User(
        id = id,
        lastName = name.split(",")[1].trim(),
        firstName = name.split(",")[0].trim(),
        age = age,
    )
}
