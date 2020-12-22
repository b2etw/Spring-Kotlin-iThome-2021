package com.example.demo.controller;

import com.example.demo.data.entity.TestEntity;
import com.example.demo.data.entity.UuidEntity;
import com.example.demo.data.enu.TestEnum;
import com.example.demo.data.repository.TestRepository;
import com.example.demo.data.repository.UuidRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class TestController {

    private final TestRepository testRepository;
    private final UuidRepository uuidRepository;

    public TestController(TestRepository testRepository, UuidRepository uuidRepository) {
        this.testRepository = testRepository;
        this.uuidRepository = uuidRepository;
    }

    @PostMapping("/test")
    void test() {
        testRepository.save(TestEntity.builder()
                .booleanCol(true)
                .stringCol("abc")
                .shortCol((short) 1)
                .integerCol(2)
                .floatCol(2.2f)
                .doubleCol(2.2d)
                .testEnumCol(TestEnum.VALUE1)
                .timestampCol(new Timestamp(System.currentTimeMillis()))
                .localDateTimeCol(LocalDateTime.now())
                .build());

        uuidRepository.save(UuidEntity.builder().build());
    }
}
