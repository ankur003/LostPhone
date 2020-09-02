package com.school.portal.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.portal.domain.base.AbstractTemporalDomain;

@Entity
public class AddressDetail extends AbstractTemporalDomain{

	private static final long serialVersionUID = 7672013356112951122L;

	@ManyToOne
	@JsonBackReference
	private User user;

	private String pincode;

	private String address;

	private String state;

	private String post;

	private String district;

	private String addressType;

	private Boolean isActive;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}


	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
}
