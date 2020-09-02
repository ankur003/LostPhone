package com.school.portal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.portal.domain.base.BaseDomain;

@Entity
public class UserClass extends BaseDomain {

	private static final long serialVersionUID = 1370919601175922061L;

	@ManyToOne
	private User user;

	private String className;

	@OneToMany(mappedBy = "userClass", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UserSection> userSection = new ArrayList<>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<UserSection> getUserSection() {
		return userSection;
	}

	public void setUserSection(List<UserSection> userSection) {
		this.userSection = userSection;
	}

}
