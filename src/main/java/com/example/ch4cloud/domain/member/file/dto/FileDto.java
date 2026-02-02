package com.example.ch4cloud.domain.member.file.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class FileDto {


    @Getter
    public static class FileUploadResponse {

        private final String key;

        public FileUploadResponse(String key) {
            this.key = key;
        }
    }

    @Getter
    public static class FileDownloadResponse {

        private final String url;

        public FileDownloadResponse(String url) {
            this.url = url;
        }
    }
}
