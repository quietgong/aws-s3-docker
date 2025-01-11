package com.plinqer.aws_s3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@RedisHash(value = "people", timeToLive = 30)
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDate created;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.created = LocalDate.now();
    }
}
