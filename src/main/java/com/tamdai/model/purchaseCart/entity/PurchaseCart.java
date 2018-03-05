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
    private String datePurchased;
    private String dateExpired;
    private String cartStatus;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UserEntity> users = new HashSet<>();

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

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public PurchaseCart(Set<Course> courses, Set<UserEntity> users) {
        this.courses = courses;
        this.users = users;
    }

    public String getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(String datePurchased) {
		this.datePurchased = datePurchased;
	}

	public String getDateExpired() {
		return dateExpired;
	}

	public void setDateExpired(String dateExpired) {
		this.dateExpired = dateExpired;
	}
	
	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public PurchaseCart(long id, String datePurchased, String dateExpired, Set<Course> courses, Set<UserEntity> users) {
		super();
		this.id = id;
		this.datePurchased = datePurchased;
		this.dateExpired = dateExpired;
		this.courses = courses;
		this.users = users;
	}
	
	

	public PurchaseCart(long id, String datePurchased, String dateExpired, String cartStatus, Set<Course> courses,
			Set<UserEntity> users) {
		super();
		this.id = id;
		this.datePurchased = datePurchased;
		this.dateExpired = dateExpired;
		this.cartStatus = cartStatus;
		this.courses = courses;
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartStatus == null) ? 0 : cartStatus.hashCode());
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((dateExpired == null) ? 0 : dateExpired.hashCode());
		result = prime * result + ((datePurchased == null) ? 0 : datePurchased.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseCart other = (PurchaseCart) obj;
		if (cartStatus == null) {
			if (other.cartStatus != null)
				return false;
		} else if (!cartStatus.equals(other.cartStatus))
			return false;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (dateExpired == null) {
			if (other.dateExpired != null)
				return false;
		} else if (!dateExpired.equals(other.dateExpired))
			return false;
		if (datePurchased == null) {
			if (other.datePurchased != null)
				return false;
		} else if (!datePurchased.equals(other.datePurchased))
			return false;
		if (id != other.id)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseCart [id=" + id + ", datePurchased=" + datePurchased + ", dateExpired=" + dateExpired
				+ ", cartStatus=" + cartStatus + ", courses=" + courses + ", users=" + users + "]";
	}

}
