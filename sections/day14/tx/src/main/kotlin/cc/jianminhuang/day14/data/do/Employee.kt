package cc.jianminhuang.day14.data.`do`

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class Employee(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var userId: Long,

    @Column
    var firstName: String,

    @Column
    var onBroadDate: LocalDateTime,
)
