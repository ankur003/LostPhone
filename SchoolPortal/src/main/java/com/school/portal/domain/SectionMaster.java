package com.school.portal.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.portal.domain.base.AbstractTemporalDomain;

@Entity
public class SectionMaster extends AbstractTemporalDomain {

	private static final long serialVersionUID = -8670346331314576431L;

	private String sectionName;

	@ManyToOne
	@JsonBackReference
	private ClassMaster classMaster;

	private Boolean isActive = true;

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ClassMaster getClassMaster() {
		return classMaster;
	}

	public void setClassMaster(ClassMaster classMaster) {
		this.classMaster = classMaster;
	}
}
