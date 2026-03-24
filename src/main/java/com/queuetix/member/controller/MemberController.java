package com.queuetix.member.controller;

import com.queuetix.member.dto.MemberResponse;
import com.queuetix.member.dto.MemberSignUpRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    public MemberController() {}

    @PostMapping("/members")
    public MemberResponse addMember(@RequestBody @Valid MemberSignUpRequest request) {
        return null;
    }
}
