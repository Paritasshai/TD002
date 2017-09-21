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

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UserEntity> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<CourseItem> courseItems = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageCourse> imageCourses = new HashSet<>();

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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", courseItems=" + courseItems +
                ", imageCourses=" + imageCourses +
                '}';
    }

    public Course(String name, String description, Set<UserEntity> users, Set<CourseItem> courseItems, Set<ImageCourse> imageCourses) {
        this.name = name;
        this.description = description;
        this.users = users;
        this.courseItems = courseItems;
        this.imageCourses = imageCourses;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
