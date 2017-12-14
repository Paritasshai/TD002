package com.tamdai.model.robomind.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Content {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "stStudentId")
    private String stStudentId;

    @Column(name = "stContent", length = 2000)
    private String stContent;

    @Column(name = "contentDate")
    private String contentDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ContentImg> contentImgs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStStudentId() {
        return stStudentId;
    }

    public void setStStudentId(String stStudentId) {
        this.stStudentId = stStudentId;
    }

    public String getStContent() {
        return stContent;
    }

    public void setStContent(String stContent) {
        this.stContent = stContent;
    }

    public Set<ContentImg> getContentImgs() {
        return contentImgs;
    }

    public void setContentImgs(Set<ContentImg> contentImgs) {
        this.contentImgs = contentImgs;
    }

    public String getContentDate() {
        return contentDate;
    }

    public void setContentDate(String contentDate) {
        this.contentDate = contentDate;
    }

    public Content() {
    }

    public Content(String stStudentId, String stContent) {
        this.stStudentId = stStudentId;
        this.stContent = stContent;
    }

    public Content(String stStudentId, String stContent, Set<ContentImg> contentImgs) {
        this.stStudentId = stStudentId;
        this.stContent = stContent;
        this.contentImgs = contentImgs;
    }

    public Content(String stStudentId, String stContent, String contentDate, Set<ContentImg> contentImgs) {
        this.stStudentId = stStudentId;
        this.stContent = stContent;
        this.contentDate = contentDate;
        this.contentImgs = contentImgs;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", stStudentId='" + stStudentId + '\'' +
                ", stContent='" + stContent + '\'' +
                ", contentDate='" + contentDate + '\'' +
                ", contentImgs=" + contentImgs +
                '}';
    }
}
