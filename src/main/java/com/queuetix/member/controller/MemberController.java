package com.queuetix.member.controller;

import com.queuetix.member.dto.MemberSignUpRequest;
import com.queuetix.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<Void> addMember(@RequestBody @Valid MemberSignUpRequest request) {
        memberService.addMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
