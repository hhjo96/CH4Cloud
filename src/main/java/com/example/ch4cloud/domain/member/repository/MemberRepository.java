package com.example.ch4cloud.domain.member.repository;

import com.example.ch4cloud.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
