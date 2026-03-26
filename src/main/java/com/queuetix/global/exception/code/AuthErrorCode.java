package com.queuetix.global.exception.code;

import com.queuetix.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum AuthErrorCode implements ErrorCode {
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증에 실패하였습니다.")
    , FORBIDDEN(HttpStatus.FORBIDDEN, "권한이 없습니다.");

    private final HttpStatusCode httpStatusCode;
    private final String message;

    AuthErrorCode(HttpStatusCode httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }
}
