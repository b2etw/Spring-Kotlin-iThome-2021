package cc.jianminhuang.day4.data.`do`

import cc.jianminhuang.day4.data.dto.UserDto
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
@DynamicUpdate
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var firstName: String,

    @Column
    var lastName: String,

    @Column
    var age: Int,
) {
    fun toDto() = UserDto(
        id = id,
        name = "$firstName, $lastName",
        age = age
    )
}