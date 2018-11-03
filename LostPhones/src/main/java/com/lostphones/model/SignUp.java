package com.lostphones.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class SignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;

	private String fullName;
	private String email;
	private String password;

	@ApiModelProperty(hidden = true)
	private int signUpOtp;

	@ApiModelProperty(hidden = true)
	private int forgotPasswordOtp;

	@ApiModelProperty(hidden = true)
	private boolean isUserVarified = false;

	@ApiModelProperty(hidden = true)
	private Date createdOn = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getSignUpOtp() {
		return signUpOtp;
	}

	public void setSignUpOtp(int signUpOtp) {
		this.signUpOtp = signUpOtp;
	}

	public boolean isUserVarified() {
		return isUserVarified;
	}

	public void setUserVarified(boolean isUserVarified) {
		this.isUserVarified = isUserVarified;
	}

	public int getForgotPasswordOtp() {
		return forgotPasswordOtp;
	}

	public void setForgotPasswordOtp(int forgotPasswordOtp) {
		this.forgotPasswordOtp = forgotPasswordOtp;
	}

}
