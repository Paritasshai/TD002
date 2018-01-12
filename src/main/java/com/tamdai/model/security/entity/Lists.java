package com.tamdai.model.security.entity;

import com.tamdai.model.course.entity.Course;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Lists() {
    }

    public Lists(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Lists{" +
                "id=" + id +
                ", courses=" + courses +
                '}';
    }
}
