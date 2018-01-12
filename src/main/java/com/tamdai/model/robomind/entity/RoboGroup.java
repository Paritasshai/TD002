package com.tamdai.model.robomind.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RoboGroup {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "groupName")
    private String groupName;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<RoboGroup> roboGroups = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<RoboGroup> getRoboGroups() {
        return roboGroups;
    }

    public void setRoboGroups(Set<RoboGroup> roboGroups) {
        this.roboGroups = roboGroups;
    }

    public RoboGroup() {
    }

    public RoboGroup(String groupName, Set<RoboGroup> roboGroups) {
        this.groupName = groupName;
        this.roboGroups = roboGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoboGroup roboGroup = (RoboGroup) o;

        if (id != null ? !id.equals(roboGroup.id) : roboGroup.id != null) return false;
        if (groupName != null ? !groupName.equals(roboGroup.groupName) : roboGroup.groupName != null) return false;
        return roboGroups != null ? roboGroups.equals(roboGroup.roboGroups) : roboGroup.roboGroups == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (roboGroups != null ? roboGroups.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoboGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", roboGroups=" + roboGroups +
                '}';
    }
}
