package com.example.ch4cloud.controller;

import com.example.ch4cloud.dto.MemberCreateDto;
import com.example.ch4cloud.dto.MemberGetDto;
import com.example.ch4cloud.service.MemberService;



import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/api/members")
    public ResponseEntity<MemberCreateDto.Response> createMember(@RequestBody MemberCreateDto.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.create(request));
    }


    @GetMapping("/api/members/{id}")
    public ResponseEntity<MemberGetDto.Response> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }



}
