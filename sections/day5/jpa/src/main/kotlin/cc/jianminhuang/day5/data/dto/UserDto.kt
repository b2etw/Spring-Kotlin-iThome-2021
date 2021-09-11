package cc.jianminhuang.day5.data.dto

import cc.jianminhuang.day5.data.`do`.User
import cc.jianminhuang.day5.data.enu.Gender
import java.math.BigDecimal
import java.time.LocalDateTime

data class UserDto(

    val id: Long?,

    val name: String,

    val age: Int,

    val gender: Gender,

    val balance: BigDecimal,

    val createTime: LocalDateTime?,
) {
    fun toDo() = User(
        id = id,
        lastName = name.split(",")[1].trim(),
        firstName = name.split(",")[0].trim(),
        age = age,
        gender = gender,
        balance = balance,
        createTime = createTime,
    )
}
