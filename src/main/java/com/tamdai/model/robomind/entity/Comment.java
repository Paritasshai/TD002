package com.tamdai.model.robomind.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "comment", length = 2000)
    private String comment;

    @Column(name = "createDate")
    private String createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(String comment, String createDate) {
        this.comment = comment;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
