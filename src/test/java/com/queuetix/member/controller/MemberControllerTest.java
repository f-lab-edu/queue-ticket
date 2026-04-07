package com.queuetix.member.controller;

import com.queuetix.member.dto.MemberSignUpRequest;
import com.queuetix.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.awaitility.Awaitility.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(MemberController.class)
class MemberControllerTest {
    private MemberController memberController;
    @MockitoBean
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberController = new MemberController(memberService);
    }

    @Test
    @DisplayName("회원가입 성공")
    void addMembersTest() {
        MemberSignUpRequest request = new MemberSignUpRequest("test", "1234", "테스트", "test@test.com", null, null);
//        when(memberService.addMember(any(MemberSignUpRequest.class))).then(invocation -> invocation.getArgument(0));

        ResponseEntity<Void> result =  memberController.addMember(request);
    }
}