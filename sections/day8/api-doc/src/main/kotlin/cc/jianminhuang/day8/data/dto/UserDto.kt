package cc.jianminhuang.day8.data.dto

import cc.jianminhuang.day8.data.`do`.User
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

data class UserDto(

    @Schema(title = "User Id")
    val id: Long?,

    @Size(min = 5, max = 50)
    @Schema(title = "User Name")
    val name: String,

    @Min(2)
    @Max(120)
    @Schema(title = "User Age")
    val age: Int,
) {
    fun toDo() = User(
        id = id,
        lastName = name.split(",")[1].trim(),
        firstName = name.split(",")[0].trim(),
        age = age,
    )
}
