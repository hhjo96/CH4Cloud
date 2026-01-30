package com.example.ch4cloud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberCreateDto {

    @Getter
    public static class Request{
        @NotBlank
        private String name;

        private int age;

        private String mbti;

    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        private final String name;
        private final int age;
        private final String mbti;
    }


}
