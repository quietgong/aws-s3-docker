package com.plinqer.aws_s3.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class S3Dto {
    @JsonIgnore
    private final String baseUrl = "https://plinqer-dev.s3.ap-northeast-2.amazonaws.com/";
    private int status;
    private List<String> path;

    public S3Dto(List<String> uploadFile) {
        this.status = 200;
        this.path = uploadFile.stream().map(m -> baseUrl + m).collect(Collectors.toList());
    }
}
