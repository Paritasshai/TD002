package com.tamdai.model.course.entity;

import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.entity.UserImage;
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

    @Column(name = "description", length = 2000)
    private String description;

    private String price;
    private String publicCourse;
    private String linkCourse;
    private String courseType;
    private String catagory;
    public int showLock;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<CourseImage> courseImages = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UserEntity> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<CourseItem> courseItems = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageCourse> imageCourses = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public int getShowLock() {
        return showLock;
    }

    public void setShowLock(int showLock) {
        this.showLock = showLock;
    }

    public Set<CourseImage> getCourseImages() {
        return courseImages;
    }

    public void setCourseImages(Set<CourseImage> courseImages) {
        this.courseImages = courseImages;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
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

    public Course() {
    }

    public Course(Long id, Long userId, String name, String description, String price, String publicCourse, String linkCourse, String courseType, String catagory, Set<CourseImage> courseImages) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseType = courseType;
        this.catagory = catagory;
        this.courseImages = courseImages;
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

    public Course(Long userId, String name, String description, String price, String publicCourse, String linkCourse, String courseType, String catagory, int showLock, Set<CourseImage> courseImages, Set<UserEntity> users, Set<CourseItem> courseItems) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseType = courseType;
        this.catagory = catagory;
        this.showLock = showLock;
        this.courseImages = courseImages;
        this.users = users;
        this.courseItems = courseItems;
    }

    public Course(Long userId, String name, String description, String price, String publicCourse, String linkCourse, String courseType, String catagory, int showLock, Set<CourseImage> courseImages, Set<UserEntity> users, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.publicCourse = publicCourse;
        this.linkCourse = linkCourse;
        this.courseType = courseType;
        this.catagory = catagory;
        this.showLock = showLock;
        this.courseImages = courseImages;
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
                ", showLock=" + showLock +
                ", courseImages=" + courseImages +
                ", users=" + users +
                ", courseItems=" + courseItems +
                ", imageCourses=" + imageCourses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (showLock != course.showLock) return false;
        if (id != null ? !id.equals(course.id) : course.id != null) return false;
        if (userId != null ? !userId.equals(course.userId) : course.userId != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (price != null ? !price.equals(course.price) : course.price != null) return false;
        if (publicCourse != null ? !publicCourse.equals(course.publicCourse) : course.publicCourse != null)
            return false;
        if (linkCourse != null ? !linkCourse.equals(course.linkCourse) : course.linkCourse != null) return false;
        if (courseType != null ? !courseType.equals(course.courseType) : course.courseType != null) return false;
        if (catagory != null ? !catagory.equals(course.catagory) : course.catagory != null) return false;
        if (courseImages != null ? !courseImages.equals(course.courseImages) : course.courseImages != null)
            return false;
        if (users != null ? !users.equals(course.users) : course.users != null) return false;
        if (courseItems != null ? !courseItems.equals(course.courseItems) : course.courseItems != null) return false;
        return imageCourses != null ? imageCourses.equals(course.imageCourses) : course.imageCourses == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (publicCourse != null ? publicCourse.hashCode() : 0);
        result = 31 * result + (linkCourse != null ? linkCourse.hashCode() : 0);
        result = 31 * result + (courseType != null ? courseType.hashCode() : 0);
        result = 31 * result + (catagory != null ? catagory.hashCode() : 0);
        result = 31 * result + showLock;
        result = 31 * result + (courseImages != null ? courseImages.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (courseItems != null ? courseItems.hashCode() : 0);
        result = 31 * result + (imageCourses != null ? imageCourses.hashCode() : 0);
        return result;
    }
}
