package cc.jianminhuang.day9.data.`do`

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var firstName: String,

    @Column
    var lastName: String,

    @Column
    var age: Int,
)