package com.plinqer.aws_s3.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseResponse<T> {
    private final int statusCode;
    private final String message;
    private final T body;

    public static <T> BaseResponse<T> success(T body) {
        return new BaseResponse<>(200, null, body);
    }
}
