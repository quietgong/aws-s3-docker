package com.plinqer.aws_s3.repository;

import com.plinqer.aws_s3.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRedisRepositoryTest {
    @Autowired
    private PersonRedisRepository repo;

    @DisplayName("REDIS 데이터 1개 생성 후 조회")
    @Test
    void test() {
        Person person = new Person("Park", 20);
        long beforeSaveCount = repo.count();
        assertEquals(0, beforeSaveCount);
        // 저장
        repo.save(person);

        // `keyspace:id` 값을 가져옴
        repo.findById(person.getId());

        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
        long afterSaveCount = repo.count();
        assertEquals(1, afterSaveCount);

        // 삭제
        repo.delete(person);
    }
}