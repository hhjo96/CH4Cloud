package com.example.ch4cloud.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberGetDto {

    @Getter
    public static class Request{
        private Long id;

    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        private final String name;
        private final int age;
        private final String mbti;
    }

}
