package com.tamdai.model.course.entity;

import com.tamdai.model.security.entity.UserEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;
    private String price;
    private String path;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<VideoClip> videoClips = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageCourse> imageCourses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UserEntity> users = new HashSet<>();

    public Set<VideoClip> getVideoClips() {
        return videoClips;
    }

    public void setVideoClips(Set<VideoClip> videoClips) {
        this.videoClips = videoClips;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public Set<ImageCourse> getImageCourses() {
        return imageCourses;
    }

    public void setImageCourses(Set<ImageCourse> imageCourses) {
        this.imageCourses = imageCourses;
    }

    public Course() {
    }

    public Course(String name, String description, String price, String path, Set<VideoClip> videoClips, Set<UserEntity> users) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.path = path;
        this.videoClips = videoClips;
        this.users = users;
    }

    public Course(String name, String description, String price, String path, Set<VideoClip> videoClips, Set<ImageCourse> imageCourses, Set<UserEntity> users) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.path = path;
        this.videoClips = videoClips;
        this.imageCourses = imageCourses;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", path='" + path + '\'' +
                ", videoClips=" + videoClips +
                ", imageCourses=" + imageCourses +
                ", users=" + users +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
