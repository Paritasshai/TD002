package com.tamdai.model.robomind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Robotic {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rbName")
    private String rbName;

    @Column(name = "nameGroup")
    private String nameGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRbName() {
        return rbName;
    }

    public void setRbName(String rbName) {
        this.rbName = rbName;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Robotic() {
    }

    public Robotic(String rbName) {
        this.rbName = rbName;
    }

    public Robotic(String rbName, String nameGroup) {
        this.rbName = rbName;
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return "Robotic{" +
                "id=" + id +
                ", rbName='" + rbName + '\'' +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }
}
