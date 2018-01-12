package com.tamdai.model.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class courseText {

    @Id
    @GeneratedValue
    private Long id;
    private String textitem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextitem() {
        return textitem;
    }

    public void setTextitem(String textitem) {
        this.textitem = textitem;
    }

    public courseText() {

    }

    public courseText(String textitem) {
        this.textitem = textitem;
    }

    @Override
    public String toString() {
        return "courseText{" +
                "id=" + id +
                ", textitem='" + textitem + '\'' +
                '}';
    }
}
