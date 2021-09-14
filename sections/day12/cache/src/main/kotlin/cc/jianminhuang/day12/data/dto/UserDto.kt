package cc.jianminhuang.day12.data.dto

import cc.jianminhuang.day12.data.`do`.User
import java.io.Serializable

data class UserDto(

    val id: Long?,

    val name: String,

    val age: Int,
) : Serializable {
    fun toDo() = User(
        id = id,
        lastName = name.split(",")[1].trim(),
        firstName = name.split(",")[0].trim(),
        age = age,
    )
}
