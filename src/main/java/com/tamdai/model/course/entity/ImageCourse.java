package com.tamdai.model.course.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Film on 18/9/2560.
 */

@Entity
public class ImageCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ImageName;
    private String ImageContentType;

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

    public void setImageContentType(String imagecontentType) {
        ImageContentType = imagecontentType;
    }

    public ImageCourse() {
    }

    public ImageCourse(String imageName, String imageContentType) {
        ImageName = imageName;
        ImageContentType = imageContentType;
    }

    @Override
    public String toString() {
        return "ImageCourse{" +
                "id=" + id +
                ", ImageName='" + ImageName + '\'' +
                ", ImagecontentType='" + ImageContentType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageCourse that = (ImageCourse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ImageName != null ? !ImageName.equals(that.ImageName) : that.ImageName != null) return false;
        return ImageContentType != null ? ImageContentType.equals(that.ImageContentType) : that.ImageContentType == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ImageName != null ? ImageName.hashCode() : 0);
        result = 31 * result + (ImageContentType != null ? ImageContentType.hashCode() : 0);
        return result;
    }

}
