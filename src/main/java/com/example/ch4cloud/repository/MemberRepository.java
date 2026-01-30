package com.example.ch4cloud.repository;

import com.example.ch4cloud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
