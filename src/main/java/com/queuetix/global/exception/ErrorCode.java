package com.queuetix.global.exception;

import org.springframework.http.HttpStatusCode;

public interface ErrorCode {
    String name();
    HttpStatusCode getHttpStatusCode();
    String getMessage();
}
