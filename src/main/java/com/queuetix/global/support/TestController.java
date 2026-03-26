package com.queuetix.global.support;

import com.queuetix.global.exception.QueueTixException;
import com.queuetix.global.exception.code.ReservationErrorCode;
import com.queuetix.member.dto.MemberLoginRequest;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("local")
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("queue-tix")
    public void queueTixException() {
        throw new QueueTixException(ReservationErrorCode.RESERVATION_NOT_FOUND);
    }

    @GetMapping("/illlegal-argument")
    public void illegalArgumentException() {
        throw new IllegalArgumentException("부적절한 파라미터 오류 테스트");
    }

    @GetMapping("/server-error")
    public void serverError() throws Exception {
        throw new Exception("서버 오류 테스트");
    }

    @GetMapping("/validation")
    public void validation(@RequestBody @Valid MemberLoginRequest request) {
    }
}
