package com.queuetix.member.service;

import com.queuetix.global.exception.QueueTixException;
import com.queuetix.global.exception.code.MemberErrorCode;
import com.queuetix.member.domain.Member;
import com.queuetix.member.dto.MemberSignUpRequest;
import com.queuetix.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository,  PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Long addMember(MemberSignUpRequest request) throws QueueTixException {
        checkMemberDuplicated(request);

        Member member = new Member();
        member.setLoginId(request.loginId());
        member.setName(request.name());
        member.setEmail(request.email());
        member.setPhone(request.phone());
        member.setPassword(passwordEncoder.encode(request.password()));
        member.setAddress(request.address());

        Member saved = memberRepository.save(member);
        return saved.getId();
    }

    private void checkMemberDuplicated(MemberSignUpRequest request) {
        if (getMemberByLoginId(request.loginId()) != null) {
            throw new QueueTixException(MemberErrorCode.MEMBER_DUPLICATED_LOGIN_ID);
        }
        if (getMemberByEmail(request.email()) != null) {
            throw new QueueTixException(MemberErrorCode.MEMBER_DUPLICATED_EMAIL);
        }
        if (getMemberByPhone(request.phone()) != null) {
            throw new QueueTixException(MemberErrorCode.MEMBER_DUPLICATED_PHONE);
        }
    }

    public Member getMemberByLoginId(String loginId) throws QueueTixException {
        return memberRepository.findByLoginId(loginId)
                .orElse(null);
    }
    public Member getMemberByPhone(String phone) throws QueueTixException {
        return memberRepository.findByPhone(phone)
                .orElse(null);
    }
    public Member getMemberByEmail(String email) throws QueueTixException {
        return memberRepository.findByEmail(email)
                .orElse(null);
    }
}
