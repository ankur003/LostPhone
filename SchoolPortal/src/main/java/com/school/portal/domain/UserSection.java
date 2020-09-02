package com.school.portal.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.school.portal.domain.base.BaseDomain;

@Entity
public class UserSection extends BaseDomain {
	
	private static final long serialVersionUID = 6527180254199253076L;

	@ManyToOne
	private UserClass classNames;

	private String sectionName;

	public UserClass getClassNames() {
		return classNames;
	}

	public void setClassNames(UserClass classNames) {
		this.classNames = classNames;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

}
