package com.tamdai.model.course.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CourseItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String orderItem;
    private String courseType;
    private String name;
    private String description;
    private String level;
    private String path;
    private String canPreview;
    private String videoPath;
    private String videoTime;

    @Column(name = "courseText", length = 2000)
    private String courseText;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<VideoClip> videoClips = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageItem> imageItems = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<courseText> courseTexts = new HashSet<>();

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

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

    public Set<courseText> getCourseTexts() {
        return courseTexts;
    }

    public void setCourseTexts(Set<courseText> courseTexts) {
        this.courseTexts = courseTexts;
    }

    public String getCourseText() {
        return courseText;
    }

    public void setCourseText(String courseText) {
        this.courseText = courseText;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public CourseItem() {
    }

    public CourseItem(String orderItem, String courseType, String name, String description, String level, String path, String canPreview, String videoPath, String videoTime, String courseText, Set<VideoClip> videoClips, Set<ImageItem> imageItems, Set<com.tamdai.model.course.entity.courseText> courseTexts) {
        this.orderItem = orderItem;
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.level = level;
        this.path = path;
        this.canPreview = canPreview;
        this.videoPath = videoPath;
        this.videoTime = videoTime;
        this.courseText = courseText;
        this.videoClips = videoClips;
        this.imageItems = imageItems;
        this.courseTexts = courseTexts;
    }

    public CourseItem(String courseType, String name, String description, String level, String path, String canPreview, String videoPath, Set<VideoClip> videoClips, Set<ImageItem> imageItems) {
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.level = level;
        this.path = path;
        this.canPreview = canPreview;
        this.videoPath = videoPath;
        this.videoClips = videoClips;
        this.imageItems = imageItems;
    }

    public CourseItem(Long id, String courseType, String name, String description, String canPreview) {
        this.id = id;
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.canPreview = canPreview;
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

    public CourseItem(String courseType, String name, String description, String level, String path, String canPreview, String videoPath, Set<VideoClip> videoClips, Set<ImageItem> imageItems, Set<courseText> courseTexts) {
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.level = level;
        this.path = path;
        this.canPreview = canPreview;
        this.videoPath = videoPath;
        this.videoClips = videoClips;
        this.imageItems = imageItems;
        this.courseTexts = courseTexts;
    }

    public CourseItem(String courseType, String name, String description, String level, String path, String canPreview, String videoPath, String courseText, Set<VideoClip> videoClips, Set<ImageItem> imageItems, Set<com.tamdai.model.course.entity.courseText> courseTexts) {
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.level = level;
        this.path = path;
        this.canPreview = canPreview;
        this.videoPath = videoPath;
        this.courseText = courseText;
        this.videoClips = videoClips;
        this.imageItems = imageItems;
        this.courseTexts = courseTexts;
    }

    public CourseItem(String courseType, String name, String description, String level, String path, String canPreview, String videoPath, String videoTime, String courseText, Set<VideoClip> videoClips, Set<ImageItem> imageItems, Set<com.tamdai.model.course.entity.courseText> courseTexts) {
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.level = level;
        this.path = path;
        this.canPreview = canPreview;
        this.videoPath = videoPath;
        this.videoTime = videoTime;
        this.courseText = courseText;
        this.videoClips = videoClips;
        this.imageItems = imageItems;
        this.courseTexts = courseTexts;
    }

    @Override
    public String toString() {
        return "CourseItem{" +
                "id=" + id +
                ", orderItem='" + orderItem + '\'' +
                ", courseType='" + courseType + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", path='" + path + '\'' +
                ", canPreview='" + canPreview + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", videoTime='" + videoTime + '\'' +
                ", courseText='" + courseText + '\'' +
                ", videoClips=" + videoClips +
                ", imageItems=" + imageItems +
                ", courseTexts=" + courseTexts +
                '}';
    }
}
