package com.example.ch4cloud.domain.member.file.service;

import com.example.ch4cloud.domain.member.entity.Member;
import com.example.ch4cloud.domain.member.repository.MemberRepository;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {
    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofDays(7);

    private final S3Template s3Template;
    private final MemberRepository memberRepository;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(Long id, MultipartFile file) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalStateException("멤버가 없습니다"));

        try {
            String profileKey = "uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(bucket, profileKey, file.getInputStream());
            member.updateProfileKey(profileKey);
            memberRepository.save(member);
            return "파일 업로드 완료, url: " + profileKey;
        } catch (IOException e) {
            throw new IllegalStateException("파일 업로드 실패", e);
        }
    }

    public URL getDownloadUrl(Long id, String key) {
        return s3Template.createSignedGetURL(bucket, key, PRESIGNED_URL_EXPIRATION);
    }



}
