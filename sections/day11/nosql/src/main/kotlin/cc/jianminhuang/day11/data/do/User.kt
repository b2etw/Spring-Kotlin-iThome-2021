package cc.jianminhuang.day11.data.`do`

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(

    @Id
    val id: String?,

    var firstName: String,

    var lastName: String,

    var age: Int,

    )