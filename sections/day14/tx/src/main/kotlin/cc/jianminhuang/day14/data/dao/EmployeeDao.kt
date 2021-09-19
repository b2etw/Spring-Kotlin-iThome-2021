package cc.jianminhuang.day14.data.dao

import cc.jianminhuang.day14.data.`do`.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface EmployeeDao: JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
}