package com.example.demo.controller;

import com.example.demo.data.entity.TestEntity;
import com.example.demo.data.entity.UuidEntity;
import com.example.demo.data.enu.TestEnum;
import com.example.demo.data.repository.TestRepository;
import com.example.demo.data.repository.UuidRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@RestController
public class TestController {

    private final TestRepository testRepository;
    private final UuidRepository uuidRepository;

    public TestController(TestRepository testRepository, UuidRepository uuidRepository) {
        this.testRepository = testRepository;
        this.uuidRepository = uuidRepository;
    }

    @GetMapping("/test")
    String testGet(@RequestParam Long id) {
        TestEntity testEntity = testRepository.findById(id).orElseThrow(RuntimeException::new);
        return testEntity.getOffsetDateTimeCol().toString();
    }

    @PostMapping("/test")
    void test() {
        TestEntity abc = TestEntity.builder()
                .booleanCol(true)
                .stringCol("abc")
                .shortCol((short) 1)
                .integerCol(2)
                .floatCol(2.2f)
                .doubleCol(2.2d)
                .testEnumCol(TestEnum.VALUE1)
                .offsetDateTimeCol(OffsetDateTime.now(ZoneOffset.UTC))
                .localDateTimeCol(LocalDateTime.now())
                .build();

        System.out.println(abc);

        testRepository.save(abc);


        uuidRepository.save(UuidEntity.builder().build());
    }
}
