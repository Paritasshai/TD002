package com.tamdai.model.robomind.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "StudentProfile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "stId")
    private String stId;

    @Column(name = "stNickname")
    private String stNickname;

    @Column(name = "stFirstname")
    private String stFirstname;

    @Column(name = "stLastname")
    private String stLastname;

    @Column(name = "stSchool")
    private String stSchool;

    @Column(name = "stDate")
    private String stDate;

    @Column(name = "stAge")
    private String stAge;

    @Column(name = "stParent")
    private String stParent;

    @Column(name = "stEmail")
    private String stEmail;

    @Column(name = "stMobile")
    private String stMobile;

    @Column(name = "stStart")
    private String stStart;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<RoboImage> roboImageSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Content> contents = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStNickname() {
        return stNickname;
    }

    public void setStNickname(String stNickname) {
        this.stNickname = stNickname;
    }

    public String getStFirstname() {
        return stFirstname;
    }

    public void setStFirstname(String stFirstname) {
        this.stFirstname = stFirstname;
    }

    public String getStLastname() {
        return stLastname;
    }

    public void setStLastname(String stLastname) {
        this.stLastname = stLastname;
    }

    public String getStSchool() {
        return stSchool;
    }

    public void setStSchool(String stSchool) {
        this.stSchool = stSchool;
    }

    public String getStDate() {
        return stDate;
    }

    public void setStDate(String stDate) {
        this.stDate = stDate;
    }

    public String getStAge() {
        return stAge;
    }

    public void setStAge(String stAge) {
        this.stAge = stAge;
    }

    public String getStParent() {
        return stParent;
    }

    public void setStParent(String stParent) {
        this.stParent = stParent;
    }

    public String getStEmail() {
        return stEmail;
    }

    public void setStEmail(String stEmail) {
        this.stEmail = stEmail;
    }

    public String getStMobile() {
        return stMobile;
    }

    public void setStMobile(String stMobile) {
        this.stMobile = stMobile;
    }

    public String getStStart() {
        return stStart;
    }

    public void setStStart(String stStart) {
        this.stStart = stStart;
    }

    public Set<RoboImage> getRoboImageSet() {
        return roboImageSet;
    }

    public void setRoboImageSet(Set<RoboImage> roboImageSet) {
        this.roboImageSet = roboImageSet;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    public StudentProfile() {
    }

    public StudentProfile(String stId, String stNickname, String stFirstname, String stLastname, String stSchool, String stDate, String stAge, String stParent, String stEmail, String stMobile, String stStart) {
        this.stId = stId;
        this.stNickname = stNickname;
        this.stFirstname = stFirstname;
        this.stLastname = stLastname;
        this.stSchool = stSchool;
        this.stDate = stDate;
        this.stAge = stAge;
        this.stParent = stParent;
        this.stEmail = stEmail;
        this.stMobile = stMobile;
        this.stStart = stStart;
    }

    public StudentProfile(String stId, String stNickname, String stFirstname, String stLastname, String stSchool, String stDate, String stAge, String stParent, String stEmail, String stMobile, String stStart, Set<RoboImage> roboImageSet, Set<Content> contents) {
        this.stId = stId;
        this.stNickname = stNickname;
        this.stFirstname = stFirstname;
        this.stLastname = stLastname;
        this.stSchool = stSchool;
        this.stDate = stDate;
        this.stAge = stAge;
        this.stParent = stParent;
        this.stEmail = stEmail;
        this.stMobile = stMobile;
        this.stStart = stStart;
        this.roboImageSet = roboImageSet;
        this.contents = contents;
    }

    public StudentProfile(String stId, String stNickname, String stFirstname, String stLastname, String stSchool, String stDate, String stAge, String stParent, String stEmail, String stMobile, String stStart, Set<RoboImage> roboImageSet) {
        this.stId = stId;
        this.stNickname = stNickname;
        this.stFirstname = stFirstname;
        this.stLastname = stLastname;
        this.stSchool = stSchool;
        this.stDate = stDate;
        this.stAge = stAge;
        this.stParent = stParent;
        this.stEmail = stEmail;
        this.stMobile = stMobile;
        this.stStart = stStart;
        this.roboImageSet = roboImageSet;
    }

    @Override
    public String toString() {
        return "StudentProfile{" +
                "id=" + id +
                ", stId='" + stId + '\'' +
                ", stNickname='" + stNickname + '\'' +
                ", stFirstname='" + stFirstname + '\'' +
                ", stLastname='" + stLastname + '\'' +
                ", stSchool='" + stSchool + '\'' +
                ", stDate='" + stDate + '\'' +
                ", stAge='" + stAge + '\'' +
                ", stParent='" + stParent + '\'' +
                ", stEmail='" + stEmail + '\'' +
                ", stMobile='" + stMobile + '\'' +
                ", stStart='" + stStart + '\'' +
                ", roboImageSet=" + roboImageSet +
                ", contents=" + contents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProfile that = (StudentProfile) o;

        if (id != that.id) return false;
        if (stId != null ? !stId.equals(that.stId) : that.stId != null) return false;
        if (stNickname != null ? !stNickname.equals(that.stNickname) : that.stNickname != null) return false;
        if (stFirstname != null ? !stFirstname.equals(that.stFirstname) : that.stFirstname != null) return false;
        if (stLastname != null ? !stLastname.equals(that.stLastname) : that.stLastname != null) return false;
        if (stSchool != null ? !stSchool.equals(that.stSchool) : that.stSchool != null) return false;
        if (stDate != null ? !stDate.equals(that.stDate) : that.stDate != null) return false;
        if (stAge != null ? !stAge.equals(that.stAge) : that.stAge != null) return false;
        if (stParent != null ? !stParent.equals(that.stParent) : that.stParent != null) return false;
        if (stEmail != null ? !stEmail.equals(that.stEmail) : that.stEmail != null) return false;
        if (stMobile != null ? !stMobile.equals(that.stMobile) : that.stMobile != null) return false;
        if (stStart != null ? !stStart.equals(that.stStart) : that.stStart != null) return false;
        if (roboImageSet != null ? !roboImageSet.equals(that.roboImageSet) : that.roboImageSet != null) return false;
        return contents != null ? contents.equals(that.contents) : that.contents == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (stId != null ? stId.hashCode() : 0);
        result = 31 * result + (stNickname != null ? stNickname.hashCode() : 0);
        result = 31 * result + (stFirstname != null ? stFirstname.hashCode() : 0);
        result = 31 * result + (stLastname != null ? stLastname.hashCode() : 0);
        result = 31 * result + (stSchool != null ? stSchool.hashCode() : 0);
        result = 31 * result + (stDate != null ? stDate.hashCode() : 0);
        result = 31 * result + (stAge != null ? stAge.hashCode() : 0);
        result = 31 * result + (stParent != null ? stParent.hashCode() : 0);
        result = 31 * result + (stEmail != null ? stEmail.hashCode() : 0);
        result = 31 * result + (stMobile != null ? stMobile.hashCode() : 0);
        result = 31 * result + (stStart != null ? stStart.hashCode() : 0);
        result = 31 * result + (roboImageSet != null ? roboImageSet.hashCode() : 0);
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        return result;
    }
}
