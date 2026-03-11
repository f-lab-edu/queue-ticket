package com.queuetix.global.exception.code;

import com.queuetix.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@RequiredArgsConstructor
public enum QueueErrorCode implements ErrorCode {
    QUEUE_TOKEN_REQUIRED(HttpStatus.FORBIDDEN, "대기열 접근 권한이 없습니다.")
    , QUEUE_TOKEN_INVALID(HttpStatus.FORBIDDEN, "유효한 권한이 없습니다.")
    , QUEUE_TOKEN_EXPIRED(HttpStatus.CONFLICT, "권한이 만료되었습니다.")
    , QUEUE_NOT_AVALILABLE(HttpStatus.CONFLICT, "사용 가능한 대기열이 없습니다.");

    private final HttpStatusCode httpStatusCode;
    private final String message;
}