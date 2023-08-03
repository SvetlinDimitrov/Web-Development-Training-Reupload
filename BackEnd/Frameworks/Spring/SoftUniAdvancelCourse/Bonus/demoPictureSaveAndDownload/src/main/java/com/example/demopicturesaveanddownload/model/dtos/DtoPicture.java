package com.example.demopicturesaveanddownload.model.dtos;

import org.springframework.web.multipart.MultipartFile;

public class DtoPicture {
    private Long id;

    private MultipartFile file;

    public Long getId() {
        return id;
    }

    public DtoPicture setId(Long id) {
        this.id = id;
        return this;
    }

    public MultipartFile getFile() {
        return file;
    }

    public DtoPicture setFile(MultipartFile file) {
        this.file = file;
        return this;
    }
}
