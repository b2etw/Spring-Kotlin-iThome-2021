package cc.jianminhuang.day19.data.`do`

import org.springframework.data.annotation.Id

data class Member(

    @Id
    val id: Long?,

    var firstName: String,

    var lastName: String,

    var age: Int,
)