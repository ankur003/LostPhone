package com.school.portal.domain.app;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.portal.domain.base.BaseDomain;

@Entity
public class SectionMaster extends BaseDomain {

	private static final long serialVersionUID = -8670346331314576431L;

	private String sectionName;

	@ManyToOne
	@JsonBackReference
	private ClassMaster classMaster;
	
	private String sectionUuid;

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public ClassMaster getClassMaster() {
		return classMaster;
	}

	public void setClassMaster(ClassMaster classMaster) {
		this.classMaster = classMaster;
	}

	public String getSectionUuid() {
		return sectionUuid;
	}

	public void setSectionUuid(String sectionUuid) {
		this.sectionUuid = sectionUuid;
	}

}
