package com.school.portal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.portal.domain.base.BaseDomain;

@Entity
public class ClassMaster extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 613805964039887170L;

	@Column(unique = true)
	private String className;

	@OneToMany(mappedBy = "classMaster", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<SectionMaster> sectionMaster = new ArrayList<>();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<SectionMaster> getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(List<SectionMaster> sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

}