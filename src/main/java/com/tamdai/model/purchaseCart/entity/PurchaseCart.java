package com.tamdai.model.purchaseCart.entity;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.security.entity.UserEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchaseCart")
public class PurchaseCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public PurchaseCart() {
    }

    public PurchaseCart(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "PurchaseCart{" +
                "id=" + id +
                ", courses=" + courses +
                '}';
    }
}
