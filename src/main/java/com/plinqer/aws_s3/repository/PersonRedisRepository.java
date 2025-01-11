package com.plinqer.aws_s3.repository;

import com.plinqer.aws_s3.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person, String> {
}
