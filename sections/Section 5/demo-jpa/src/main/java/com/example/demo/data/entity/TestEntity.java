package com.example.demo.data.entity;

import com.example.demo.data.enu.TestEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class TestEntity implements Serializable {

    private static final long serialVersionUID = -7640136489326688917L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long longId;

    @Column
    Boolean booleanCol;

    @Column
    String stringCol;

    @Column
    Short shortCol;

    @Column
    Integer integerCol;

    @Column
    Float floatCol;

    @Column
    Double doubleCol;

    @Column
    @Enumerated(EnumType.STRING)
    TestEnum testEnumCol;

    @Column
    Timestamp timestampCol;

    @Column
    LocalDateTime localDateTimeCol;
}
