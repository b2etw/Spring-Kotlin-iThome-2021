package cc.jianminhuang.day25.data.`do`

import cc.jianminhuang.day25.data.enu.Gender

data class User(

    val id: Long?,

    var firstName: String,

    var lastName: String,

    var age: Int,

    var gender: Gender,

    var email: String,

    var phone: String,
)
