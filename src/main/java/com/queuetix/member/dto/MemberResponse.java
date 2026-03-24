package com.queuetix.member.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
}