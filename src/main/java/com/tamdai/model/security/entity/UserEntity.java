package com.tamdai.model.security.entity;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.purchaseCart.entity.PurchaseCart;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @Column(unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "lastLoginDate")
    private String lastLoginDate;

    @Column(name = "signUpDate")
    private String signUpDate;

    @Column(name = "confirmDate")
    private String confirmDate;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "createTime")
    private String createTime;

    @Column(name = "createUserID")
    private String createUserID;

    @Column(name = "updateDate")
    private String updateDate;

    @Column(name = "updateTime")
    private String updateTime;

    @Column(name = "updateUserId")
    private String updateUserId;

    @Column(name = "status", length = 2000)
    private String status;

    @Column(name = "balance")
    private String balance;

    @Column(name = "instructorBio")
    private String instructorBio;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<PurchaseCart> purchaseCarts = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private
    Set<UserImage> userImages = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Lists> lists = new HashSet<>();

    public String getInstructorBio() {
        return instructorBio;
    }

    public void setInstructorBio(String instructorBio) {
        this.instructorBio = instructorBio;
    }

    public Set<UserImage> getUserImages() {
        return userImages;
    }

    public void setUserImages(Set<UserImage> userImages) {
        this.userImages = userImages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserID() {
        return createUserID;
    }

    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Set<PurchaseCart> getPurchaseCarts() {
        return purchaseCarts;
    }

    public void setPurchaseCarts(Set<PurchaseCart> purchaseCarts) {
        this.purchaseCarts = purchaseCarts;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Lists> getLists() {
        return lists;
    }

    public void setLists(Set<Lists> lists) {
        this.lists = lists;
    }

    public UserEntity() {
    }
    
    

    public UserEntity(String email, String password, String firstName, String lastName, String lastLoginDate, String signUpDate, String confirmDate, String createDate, String createTime, String createUserID, String updateDate, String updateTime, String updateUserId, String status, String balance, Set<PurchaseCart> purchaseCarts, Set<Course> courses, Set<UserImage> userImages, Set<Lists> lists) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLoginDate = lastLoginDate;
        this.signUpDate = signUpDate;
        this.confirmDate = confirmDate;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createUserID = createUserID;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
        this.balance = balance;
        this.purchaseCarts = purchaseCarts;
        this.courses = courses;
        this.userImages = userImages;
        this.lists = lists;
    }

    public UserEntity(String email, String password, String firstName, String lastName, String lastLoginDate, String signUpDate, String confirmDate, String createDate, String createTime, String createUserID, String updateDate, String updateTime, String updateUserId, String status, String balance, Set<PurchaseCart> purchaseCarts, Set<Course> courses, Set<UserImage> userImages) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLoginDate = lastLoginDate;
        this.signUpDate = signUpDate;
        this.confirmDate = confirmDate;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createUserID = createUserID;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
        this.balance = balance;
        this.purchaseCarts = purchaseCarts;
        this.courses = courses;
        this.userImages = userImages;
    }

    public UserEntity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserEntity(Long id, String email, String password, String firstName, String lastName, String status, String balance) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.balance = balance;
    }

    public UserEntity(String email, String password, String firstName, String lastName, String lastLoginDate, String signUpDate, String confirmDate, String createDate, String createTime, String createUserID, String updateDate, String updateTime, String updateUserId, String status, String balance) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLoginDate = lastLoginDate;
        this.signUpDate = signUpDate;
        this.confirmDate = confirmDate;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createUserID = createUserID;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
        this.balance = balance;
    }

    public UserEntity(String email, String password, String firstName, String lastName, String lastLoginDate, String signUpDate, String confirmDate, String createDate, String createTime, String createUserID, String updateDate, String updateTime, String updateUserId, String status, String balance, Set<PurchaseCart> purchaseCarts) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLoginDate = lastLoginDate;
        this.signUpDate = signUpDate;
        this.confirmDate = confirmDate;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createUserID = createUserID;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
        this.balance = balance;
        this.purchaseCarts = purchaseCarts;
    }

    public UserEntity(String email, String password, String firstName, String lastName, String lastLoginDate, String signUpDate, String confirmDate, String createDate, String createTime, String createUserID, String updateDate, String updateTime, String updateUserId, String status, String balance, Set<PurchaseCart> purchaseCarts, Set<Course> courses) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLoginDate = lastLoginDate;
        this.signUpDate = signUpDate;
        this.confirmDate = confirmDate;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createUserID = createUserID;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
        this.balance = balance;
        this.purchaseCarts = purchaseCarts;
        this.courses = courses;
    }

    public UserEntity(String email, String password, String firstName, String lastName, String lastLoginDate, String signUpDate, String confirmDate, String createDate, String createTime, String createUserID, String updateDate, String updateTime, String updateUserId, String status, String balance, String instructorBio, Set<PurchaseCart> purchaseCarts, Set<Course> courses, Set<UserImage> userImages, Set<Lists> lists) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastLoginDate = lastLoginDate;
        this.signUpDate = signUpDate;
        this.confirmDate = confirmDate;
        this.createDate = createDate;
        this.createTime = createTime;
        this.createUserID = createUserID;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
        this.balance = balance;
        this.instructorBio = instructorBio;
        this.purchaseCarts = purchaseCarts;
        this.courses = courses;
        this.userImages = userImages;
        this.lists = lists;
    }

	@Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastLoginDate='" + lastLoginDate + '\'' +
                ", signUpDate='" + signUpDate + '\'' +
                ", confirmDate='" + confirmDate + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createTime='" + createTime + '\'' +
                ", createUserID='" + createUserID + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUserId='" + updateUserId + '\'' +
                ", status='" + status + '\'' +
                ", balance='" + balance + '\'' +
                ", instructorBio='" + instructorBio + '\'' +
                ", purchaseCarts=" + purchaseCarts +
                ", courses=" + courses +
                ", userImages=" + userImages +
                ", lists=" + lists +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(that.lastLoginDate) : that.lastLoginDate != null)
            return false;
        if (signUpDate != null ? !signUpDate.equals(that.signUpDate) : that.signUpDate != null) return false;
        if (confirmDate != null ? !confirmDate.equals(that.confirmDate) : that.confirmDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUserID != null ? !createUserID.equals(that.createUserID) : that.createUserID != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUserId != null ? !updateUserId.equals(that.updateUserId) : that.updateUserId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (instructorBio != null ? !instructorBio.equals(that.instructorBio) : that.instructorBio != null)
            return false;
        if (purchaseCarts != null ? !purchaseCarts.equals(that.purchaseCarts) : that.purchaseCarts != null)
            return false;
        if (courses != null ? !courses.equals(that.courses) : that.courses != null) return false;
        if (userImages != null ? !userImages.equals(that.userImages) : that.userImages != null) return false;
        return lists != null ? lists.equals(that.lists) : that.lists == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (signUpDate != null ? signUpDate.hashCode() : 0);
        result = 31 * result + (confirmDate != null ? confirmDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUserID != null ? createUserID.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (instructorBio != null ? instructorBio.hashCode() : 0);
        result = 31 * result + (purchaseCarts != null ? purchaseCarts.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        result = 31 * result + (userImages != null ? userImages.hashCode() : 0);
        result = 31 * result + (lists != null ? lists.hashCode() : 0);
        return result;
    }
}