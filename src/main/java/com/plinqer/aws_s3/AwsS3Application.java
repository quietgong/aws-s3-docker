package com.plinqer.aws_s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AwsS3Application {
	public static void main(String[] args) {
		SpringApplication.run(AwsS3Application.class, args);
	}
}
