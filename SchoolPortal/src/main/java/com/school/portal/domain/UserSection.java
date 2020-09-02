package com.school.portal.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.school.portal.domain.base.BaseDomain;

@Entity
public class UserSection extends BaseDomain {
	
	private static final long serialVersionUID = 6527180254199253076L;

	@ManyToOne
	private UserClass userClass;

	private String sectionName;

	public UserClass getUserClass() {
		return userClass;
	}

	public void setUserClass(UserClass userClass) {
		this.userClass = userClass;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

}
