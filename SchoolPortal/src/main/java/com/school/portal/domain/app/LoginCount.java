package com.school.portal.domain.app;

import javax.persistence.Entity;

import com.school.portal.domain.base.BaseDomain;

@Entity
public class LoginCount extends BaseDomain {

	private static final long serialVersionUID = -4595989419831206375L;

	private Integer countPermited;

	public Integer getCountPermited() {
		return countPermited;
	}

	public void setCountPermited(Integer countPermited) {
		this.countPermited = countPermited;
	}

}
