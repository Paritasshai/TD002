package com.tamdai.model.course.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CourseItem implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String courseType;
    private String name;
    private String description;
    private String level;
    private String path;
    private String canPreview;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<VideoClip> videoClips = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageItem> imageItems = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCanPreview() {
        return canPreview;
    }

    public void setCanPreview(String canPreview) {
        this.canPreview = canPreview;
    }

    public Set<VideoClip> getVideoClips() {
        return videoClips;
    }

    public Set<ImageItem> getImageItems() {
        return imageItems;
    }

    public void setImageItems(Set<ImageItem> imageItems) {
        this.imageItems = imageItems;
    }

    public void setVideoClips(Set<VideoClip> videoClips) {
        this.videoClips = videoClips;
    }

    public CourseItem() {
    }

    public CourseItem(String courseType, String name, String description, String level, String path, String canPreview, Set<VideoClip> videoClips, Set<ImageItem> imageItems) {
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.level = level;
        this.path = path;
        this.canPreview = canPreview;
        this.videoClips = videoClips;
        this.imageItems = imageItems;
    }

    @Override
    public String toString() {
        return "CourseItem{" +
                "id=" + id +
                ", courseType='" + courseType + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", path='" + path + '\'' +
                ", canPreview='" + canPreview + '\'' +
                ", videoClips=" + videoClips +
                ", imageItems=" + imageItems +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
