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
    private String ImagecontentType;
    private String CreateDate;

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

    public String getImagecontentType() {
        return ImagecontentType;
    }

    public void setImagecontentType(String imagecontentType) {
        ImagecontentType = imagecontentType;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public ImageCourse() {
    }

    public ImageCourse(String imageName, String imagecontentType, String createDate) {
        ImageName = imageName;
        ImagecontentType = imagecontentType;
        CreateDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageCourse that = (ImageCourse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ImageName != null ? !ImageName.equals(that.ImageName) : that.ImageName != null) return false;
        if (ImagecontentType != null ? !ImagecontentType.equals(that.ImagecontentType) : that.ImagecontentType != null)
            return false;
        return CreateDate != null ? CreateDate.equals(that.CreateDate) : that.CreateDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ImageName != null ? ImageName.hashCode() : 0);
        result = 31 * result + (ImagecontentType != null ? ImagecontentType.hashCode() : 0);
        result = 31 * result + (CreateDate != null ? CreateDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImageCourse{" +
                "id=" + id +
                ", ImageName='" + ImageName + '\'' +
                ", ImagecontentType='" + ImagecontentType + '\'' +
                ", CreateDate='" + CreateDate + '\'' +
                '}';
    }
}
