package com.example.demopicturesaveanddownload.model.entity;

import jakarta.persistence.*;


@Entity
public class PictureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(length = Integer.MAX_VALUE)
    private byte[] file;

    @Column
    private String name;

    @Column
    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public PictureEntity setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PictureEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public byte[] getFile() {
        return file;
    }

    public PictureEntity setFile(byte[] file) {
        this.file = file;
        return this;
    }

    public String getName() {
        return name;
    }

    public PictureEntity setName(String name) {
        this.name = name;
        return this;
    }
}
