package com.tamdai.model.video.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Film on 25/9/2559.
 */

@Entity
public class VideoClip {

    @Id
    @GeneratedValue
    private Long id;

    String fileName;
    String contentType;

    @Lob
    byte[] content;

    @Temporal(TemporalType.TIMESTAMP)
    Date created;

    public VideoClip() {

    }

    public VideoClip(String fileName, String contentType, byte[] content, Date created) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.content = content;
        this.created = created;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
