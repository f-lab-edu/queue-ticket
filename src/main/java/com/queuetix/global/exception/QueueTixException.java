package com.queuetix.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QueueTixException extends RuntimeException {
    private final ErrorCode errorCode;
}
