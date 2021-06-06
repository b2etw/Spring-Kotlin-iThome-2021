package com.example.demo.rest.respository.data.repository

import com.example.demo.rest.respository.data.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface UesrRepository : JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findByName(name: String): List<User>
}