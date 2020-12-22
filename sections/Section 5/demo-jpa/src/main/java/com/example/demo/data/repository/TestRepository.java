package com.example.demo.data.repository;

import com.example.demo.data.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TestRepository extends JpaRepository<TestEntity, Long>, JpaSpecificationExecutor<TestEntity> {
}
