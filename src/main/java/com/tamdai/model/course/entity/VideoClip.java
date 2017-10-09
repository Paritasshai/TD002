package com.tamdai.model.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Film on 25/9/2559.
 */

@Entity
public class VideoClip implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;
    private String lessonName;
    private String contentType;
    private String path;
    private String createDate;

    public VideoClip() {

    }

    public VideoClip(String fileName, String lessonName, String contentType, String path, String createDate) {
        this.fileName = fileName;
        this.lessonName = lessonName;
        this.contentType = contentType;
        this.path = path;
        this.createDate = createDate;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "VideoClip{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", lessonName='" + lessonName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", path='" + path + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

}
