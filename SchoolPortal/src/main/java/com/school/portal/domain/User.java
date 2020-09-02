package com.school.portal.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.school.portal.domain.base.AbstractTemporalDomain;
import com.school.portal.enums.UserType;

@Entity
public class User extends AbstractTemporalDomain {

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

	private Integer failureLoginCount;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<AddressDetail> address = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<ClassDetail> classNames = new HashSet<>();

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<AddressDetail> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDetail> address) {
		this.address = address;
	}

	public Set<ClassDetail> getClassNames() {
		return classNames;
	}

	public void setClassNames(Set<ClassDetail> classNames) {
		this.classNames = classNames;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public int getFailureLoginCount() {
		return failureLoginCount;
	}

	public void setFailureLoginCount(int failureLoginCount) {
		this.failureLoginCount = failureLoginCount;
	}

}
