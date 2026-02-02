package com.example.ch4cloud.domain.member.controller;

import com.example.ch4cloud.domain.member.dto.MemberCreateDto;
import com.example.ch4cloud.domain.member.dto.MemberGetDto;
import com.example.ch4cloud.domain.member.service.MemberService;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/api/members")
    public ResponseEntity<MemberCreateDto.Response> createMember(@RequestBody MemberCreateDto.Request request) {
        log.info("[API - LOG] {} ", "createMember");
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.create(request));
    }


    @GetMapping("/api/members/{id}")
    public ResponseEntity<MemberGetDto.Response> getOne(@PathVariable Long id) {
        log.info("[API - LOG] {} ", "getOne");
        return ResponseEntity.ok(memberService.getMember(id));
    }



}
