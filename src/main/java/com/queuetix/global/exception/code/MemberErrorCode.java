package com.queuetix.global.exception.code;

import com.queuetix.global.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum MemberErrorCode implements ErrorCode {
    MEMBER_DUPLICATED_LOGIN_ID(HttpStatus.CONFLICT, "중복된 아이디입니다.")
    , MEMBER_DUPLICATED_EMAIL(HttpStatus.CONFLICT, "중복된 이메일입니다.")
    , MEMBER_DUPLICATED_PHONE(HttpStatus.CONFLICT, "중복된 전화번호입니다.");

    private final HttpStatusCode httpStatusCode;
    private final String message;

    MemberErrorCode(HttpStatusCode httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }
}
