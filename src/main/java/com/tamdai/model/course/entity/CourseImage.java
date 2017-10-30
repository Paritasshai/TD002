package com.tamdai.model.course.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class CourseImage {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private byte[] content;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public CourseImage() {
    }

    public CourseImage(String fileName, byte[] content, String contentType) {
        this.fileName = fileName;
        this.content = content;
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "UserImage{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", content=" + Arrays.toString(content) +
                ", contentType='" + contentType + '\'' +
                '}';
    }

}

