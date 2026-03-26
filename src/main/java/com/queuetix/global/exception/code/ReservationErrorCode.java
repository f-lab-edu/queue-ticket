package com.queuetix.global.exception.code;

import com.queuetix.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ReservationErrorCode implements ErrorCode {
    RESERVATION_NOT_OPENED(HttpStatus.CONFLICT, "티켓 예매 오픈 전입니다.")
    , SEAT_ALREADY_RESERVED(HttpStatus.CONFLICT, "이미 예약된 좌석입니다.")
    , RESERVATION_ALREADY_CONFIRMED(HttpStatus.CONFLICT, "이미 처리된 요청입니다.")
    , RESERVATION_ALREADY_CANCELLED(HttpStatus.CONFLICT, "이미 취소된 요청입니다.")
    , RESERVATION_NOT_FOUND(HttpStatus.NOT_FOUND, "예약 정보를 찾을 수 없습니다.")
    , SEAT_NOT_FOUND(HttpStatus.NOT_FOUND, "좌석 정보를 찾을 수 없습니다.");

    private final HttpStatusCode httpStatusCode;
    private final String message;

    ReservationErrorCode(HttpStatusCode httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }
}
