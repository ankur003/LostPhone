package com.school.portal.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.school.portal.domain.base.AbstractTemporalDomain;

@Entity
public class SectionNames extends AbstractTemporalDomain {
	
	private static final long serialVersionUID = 6527180254199253076L;

	@ManyToOne
	private ClassDetail classNames;

	private String sectionName;

	public ClassDetail getClassNames() {
		return classNames;
	}

	public void setClassNames(ClassDetail classNames) {
		this.classNames = classNames;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

}
