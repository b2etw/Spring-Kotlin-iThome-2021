package cc.jianminhuang.day5.data.`do`

import cc.jianminhuang.day5.data.enu.Gender
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column(length = 50)
    var firstName: String,

    @Column(length = 50)
    var lastName: String,

    @Column
    var age: Int,

    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    var gender: Gender,

    @Column(precision = 20, scale = 4)
    var balance: BigDecimal,

    @Column
    var createTime: LocalDateTime?,

    @Column
    var updateTime: LocalDateTime?,
)
