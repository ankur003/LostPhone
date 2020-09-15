package com.school.portal.domain.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.portal.domain.base.BaseDomain;

@Entity
public class ClassMaster extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 613805964039887170L;

	private String className;
	
	private String classUuid;
	
	@OneToMany(mappedBy = "classMaster", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<SectionMaster> sectionMaster = new ArrayList<>();

	public List<SectionMaster> getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(List<SectionMaster> sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassUuid() {
		return classUuid;
	}

	public void setClassUuid(String classUuid) {
		this.classUuid = classUuid;
	}
	
}