package com.tamdai.model.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ImageItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ImageName;
    private String ImageContentType;
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImageContentType() {
        return ImageContentType;
    }

    public void setImageContentType(String imageContentType) {
        ImageContentType = imageContentType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImageItem() {
    }

    public ImageItem(String imageName, String imageContentType, String path) {
        ImageName = imageName;
        ImageContentType = imageContentType;
        this.path = path;
    }

    @Override
    public String toString() {
        return "ImageItem{" +
                "id=" + id +
                ", ImageName='" + ImageName + '\'' +
                ", ImageContentType='" + ImageContentType + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

}
