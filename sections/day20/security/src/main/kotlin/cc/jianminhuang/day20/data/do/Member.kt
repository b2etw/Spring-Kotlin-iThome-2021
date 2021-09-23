package cc.jianminhuang.day20.data.`do`

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
@EntityListeners(AuditingEntityListener::class)
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var uid: String,

    @Column
    var password: String,

    @Column
    var role: String,

    @CreatedBy
    @Column
    var createBy: String?,

    @LastModifiedBy
    @Column
    var updateBy: String?,

    @CreatedDate
    @Column
    var createTime: Long?,

    @LastModifiedDate
    @Column
    var updateTime: Long?,
)
