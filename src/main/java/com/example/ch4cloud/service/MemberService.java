package com.example.ch4cloud.service;

import com.example.ch4cloud.dto.MemberCreateDto;
import com.example.ch4cloud.dto.MemberGetDto;
import com.example.ch4cloud.entity.Member;
import com.example.ch4cloud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateDto.Response create(MemberCreateDto.Request request) {
        Member member = new Member(request.getName(), request.getAge(), request.getMbti());
        Member savedMember = memberRepository.save(member);

        return new MemberCreateDto.Response(savedMember.getName(), savedMember.getAge(), savedMember.getMbti());
    }

    @Transactional(readOnly = true)
    public MemberGetDto.Response getMember(long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalStateException("멤버가 없습니다"));

        return new MemberGetDto.Response(member.getName(), member.getAge(), member.getMbti());

    }
}
