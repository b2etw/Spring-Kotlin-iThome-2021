package com.example.demo.data.repository;

import com.example.demo.data.entity.UuidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UuidRepository extends JpaRepository<UuidEntity, UUID>, JpaSpecificationExecutor<UuidEntity> {
}
