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
    private String price;
    private String publicCourse;
    private String linkCourse;
    private String courseType;
    private String catagory;
    public int showLock;


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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public Integer getShowLock() {
        return showLock;
    }

    public void setShowLock(Integer showLock) {
        this.showLock = showLock;
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

    public Course(Long id, Long userId, String name, String description, String price, String publicCourse, String linkCourse) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
    }

    public Course(Long id, Long userId, String name, String description, String price, String publicCourse, String linkCourse, String courseType, String catagory) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseType = courseType;
        this.catagory = catagory;
    }

    public Course(Long userId, String name, String description, String price, String publicCourse, String linkCourse, Set<UserEntity> users, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.users = users;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
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

    public Course(Long userId, String name, String description, String price, String publicCourse, String linkCourse, String courseType, Set<UserEntity> users, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseType = courseType;
        this.users = users;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
    }

    public Course(Long userId, String name, String description, String price, String publicCourse, String linkCourse, String courseType, String catagory, Set<UserEntity> users, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseType = courseType;
        this.catagory = catagory;
        this.users = users;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
    }

    public Course(Long userId, String name, String description, String price, String publicCourse, String linkCourse, String courseType, String catagory, Integer showLock, Set<UserEntity> users, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseType = courseType;
        this.catagory = catagory;
        this.showLock = showLock;
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
                ", price='" + price + '\'' +
                ", publicCourse='" + publicCourse + '\'' +
                ", linkCourse='" + linkCourse + '\'' +
                ", courseType='" + courseType + '\'' +
                ", catagory='" + catagory + '\'' +
                ", showLock='" + showLock + '\'' +
                ", users=" + users +
                ", courseItems=" + courseItems +
                ", imageCourses=" + imageCourses +
                '}';
    }
}
