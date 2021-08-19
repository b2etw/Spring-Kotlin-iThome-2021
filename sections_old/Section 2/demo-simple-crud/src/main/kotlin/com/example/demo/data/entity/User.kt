package com.example.demo.data.entity

import com.example.demo.data.dto.UserDto
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long?,

        @Column
        var firstName: String,

        @Column
        var lastName: String,

        @Column
        var age: Int
) {
        fun trans2Dto() = UserDto(this.id!!, "${this.firstName},${this.lastName}", this.age)
}