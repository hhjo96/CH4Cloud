package com.example.ch4cloud.domain.member.file.controller;

import com.example.ch4cloud.domain.member.file.dto.FileDto;
import com.example.ch4cloud.domain.member.file.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final S3Service s3Service;

    @PostMapping(value = "/api/members/{id}/profile-image")
    public ResponseEntity<FileDto.FileUploadResponse> upload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        log.info("[API - LOG] {} ", "upload");
        String key = s3Service.upload(id, file);
        return ResponseEntity.ok(new FileDto.FileUploadResponse(key));
    }

    @GetMapping("/api/members/{id}/profile-image")
    public ResponseEntity<FileDto.FileDownloadResponse> getDownloadUrl(@PathVariable Long id,@RequestParam String key) {
        log.info("[API - LOG] {} ", "download");
        URL url = s3Service.getDownloadUrl(id, key);
        return ResponseEntity.ok(new FileDto.FileDownloadResponse(url.toString()));
    }
}
