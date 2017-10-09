package com.tamdai.model.course.entity;

import com.tamdai.model.security.entity.UserEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;
    private Long userId;
    private String name;
    private String description;
    private String publicCourse;
    private String linkCourse;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UserEntity> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<CourseItem> courseItems = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageCourse> imageCourses = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Set<CourseItem> getCourseItems() {
        return courseItems;
    }

    public void setCourseItems(Set<CourseItem> courseItems) {
        this.courseItems = courseItems;
    }

    public Set<ImageCourse> getImageCourses() {
        return imageCourses;
    }

    public void setImageCourses(Set<ImageCourse> imageCourses) {
        this.imageCourses = imageCourses;
    }

    public String getPublicCourse() {
        return publicCourse;
    }

    public void setPublicCourse(String publicCourse) {
        this.publicCourse = publicCourse;
    }

    public String getLinkCourse() {
        return linkCourse;
    }

    public void setLinkCourse(String linkCourse) {
        this.linkCourse = linkCourse;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    //    public Set<UserEntity> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<UserEntity> users) {
//        this.users = users;
//    }

    public Course() {
    }

    public Course(Long id, Long userId, String name, String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
    }

    public Course(Long id, Long userId, String name, String description, String publicCourse, String linkCourse) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
    }

    public Course(Long userId, String name, String description, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
    }

    public Course(Long userId, String name, String description, String publicCourse, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.publicCourse = publicCourse;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
    }

    public Course(Long userId, String name, String description, String publicCourse, String linkCourse, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
    }

    public Course(Long userId, String name, String description, String publicCourse, String linkCourse, Set<UserEntity> users, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.users = users;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publicCourse='" + publicCourse + '\'' +
                ", linkCourse='" + linkCourse + '\'' +
                ", users=" + users +
                ", courseItems=" + courseItems +
                ", imageCourses=" + imageCourses +
                '}';
    }
}
