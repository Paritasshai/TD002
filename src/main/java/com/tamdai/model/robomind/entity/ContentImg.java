package com.tamdai.model.robomind.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContentImg {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private String contentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public ContentImg() {
    }

    public ContentImg(String fileName, String contentType) {
        this.fileName = fileName;
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "ContentImg{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
