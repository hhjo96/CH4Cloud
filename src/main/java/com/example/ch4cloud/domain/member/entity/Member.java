package com.example.ch4cloud.domain.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor

public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //vo로 하는 게 좋지만 과제의 목적이 클라우드 다루기이므로 그냥 int로 하였음
    private int age;

    private String mbti;

    private String profileKey;

    public Member(String name, int age, String mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    public void updateProfileKey(String str) {
        this.profileKey = str;
    }

}
