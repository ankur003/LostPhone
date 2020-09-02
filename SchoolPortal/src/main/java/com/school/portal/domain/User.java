package com.school.portal.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.portal.domain.base.BaseDomain;
import com.school.portal.enums.UserType;

@Entity
public class User extends BaseDomain {

	private static final long serialVersionUID = -1293783007980955204L;

	private String username;

	@JsonIgnore
	private String password;

	@Enumerated(EnumType.STRING)
	private UserType userType;

	private LocalDate dob;

	private LocalDate doj;

	private Long rollNo;

	private String name;

	private Boolean isAdmin;

	private Boolean isActive;

	private Boolean isBlocked;

	private Integer failureLoginAttempt;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<AddressDetail> address = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UserClass> userClass = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Integer getFailureLoginAttempt() {
		return failureLoginAttempt;
	}

	public void setFailureLoginAttempt(Integer failureLoginAttempt) {
		this.failureLoginAttempt = failureLoginAttempt;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<AddressDetail> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDetail> address) {
		this.address = address;
	}

	public List<UserClass> getUserClass() {
		return userClass;
	}

	public void setUserClass(List<UserClass> userClass) {
		this.userClass = userClass;
	}

}
