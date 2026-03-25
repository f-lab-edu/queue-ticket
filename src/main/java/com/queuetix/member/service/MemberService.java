package com.queuetix.member.service;

import com.queuetix.member.domain.Member;
import com.queuetix.member.dto.MemberSignUpRequest;
import com.queuetix.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void addMember(MemberSignUpRequest request) {
        Member member = new Member();
        member.setLoginId(request.getLoginId());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        member.setPassword(request.getPassword());
        member.setAddress(request.getAddress());

        memberRepository.save(member);
    }
}
