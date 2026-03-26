package com.queuetix.member.service;

import com.queuetix.global.exception.QueueTixException;
import com.queuetix.global.exception.code.MemberErrorCode;
import com.queuetix.member.domain.Member;
import com.queuetix.member.dto.MemberSignUpRequest;
import com.queuetix.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    private MemberSignUpRequest request;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository, passwordEncoder);

        request = new MemberSignUpRequest("alrscent", "1111", "이미향", "mihyang.sol.lee@gmail.com", "010-1234-5678", "서울시 강남구");
    }

    @Test
    @DisplayName("회원가입 성공시 저장된 회원ID를 리턴한다")
    void addMember() {
        Member willReturnMember = new Member();
        willReturnMember.setId(1L);

        when(memberRepository.findByLoginId(request.loginId())).thenReturn(Optional.empty());
        when(memberRepository.findByPhone(request.phone())).thenReturn(Optional.empty());
        when(memberRepository.findByEmail(request.email())).thenReturn(Optional.empty());

        when(passwordEncoder.encode(any(String.class))).thenReturn("encoded");
        when(memberRepository.save(any(Member.class))).thenReturn(willReturnMember);

        Long id = memberService.addMember(request);

        assertThat(id).isEqualTo(1L);
    }

    @Test
    @DisplayName("회원가입시 기존 회원중 동일한 로그인 아이디 존재하면 오류 발생한다")
    void addMemberFail1() {
        when(memberRepository.findByLoginId(any(String.class))).thenReturn(Optional.of(new Member()));
        QueueTixException exception = assertThrows(QueueTixException.class, () -> memberService.addMember(request));

        assertThat(exception.getErrorCode()).isSameAs(MemberErrorCode.MEMBER_DUPLICATED_LOGIN_ID);
    }

    @Test
    @DisplayName("회원가입시 기존 회원중 동일한 이메일 존재하면 오류 발생한다")
    void addMemberFail2() {
        when(memberRepository.findByEmail(any(String.class))).thenReturn(Optional.of(new Member()));
        when(memberRepository.findByLoginId(any(String.class))).thenReturn(Optional.empty());
        QueueTixException exception = assertThrows(QueueTixException.class, () -> memberService.addMember(request));

        assertThat(exception.getErrorCode()).isSameAs(MemberErrorCode.MEMBER_DUPLICATED_EMAIL);
    }

    @Test
    @DisplayName("회원가입시 기존 회원중 동일한 휴대폰 번호 존재하면 오류 발생한다")
    void addMemberFail3() {
        when(memberRepository.findByLoginId(any(String.class))).thenReturn(Optional.empty());
        when(memberRepository.findByEmail(any(String.class))).thenReturn(Optional.empty());
        when(memberRepository.findByPhone(any(String.class))).thenReturn(Optional.of(new Member()));
        QueueTixException exception = assertThrows(QueueTixException.class, () -> memberService.addMember(request));

        assertThat(exception.getErrorCode()).isSameAs(MemberErrorCode.MEMBER_DUPLICATED_PHONE);
    }
}