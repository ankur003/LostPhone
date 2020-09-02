package com.school.portal.domain.app;

import javax.persistence.Entity;

import com.school.portal.domain.base.BaseDomain;

@Entity
public class LoginCount extends BaseDomain{

	private static final long serialVersionUID = -4595989419831206375L;

	private Integer countPermited;

	private boolean isLoginCountActive = false;

	public Integer getLoginCount() {
		return countPermited;
	}

	public void setLoginCount(Integer countPermited) {
		this.countPermited = countPermited;
	}

	public boolean isLoginCountActive() {
		return isLoginCountActive;
	}

	public void setLoginCountActive(boolean isLoginCountActive) {
		this.isLoginCountActive = isLoginCountActive;
	}

}
