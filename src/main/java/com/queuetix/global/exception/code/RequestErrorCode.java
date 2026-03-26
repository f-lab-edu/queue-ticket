package com.queuetix.global.exception.code;

import com.queuetix.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum RequestErrorCode implements ErrorCode {
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "유효하지 않은 요청입니다.")
    , INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "유효하지 않은 입력입니다.");

    private final HttpStatusCode httpStatusCode;
    private final String message;

    RequestErrorCode(HttpStatusCode httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }
}
