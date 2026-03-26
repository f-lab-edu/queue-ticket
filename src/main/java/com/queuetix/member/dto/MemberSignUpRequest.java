package com.queuetix.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public record MemberSignUpRequest (
    @NotBlank(message = "로그인 아이디를 입력해주세요")
    String loginId,
    @NotBlank(message = "비밀번호를 입력해주세요.")
    String password,
    @NotBlank(message = "성함을 입력해주세요.")
    String name,
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    String email,
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 형식이 올바르지 않습니다.")
    String phone,
    String address
) {}
