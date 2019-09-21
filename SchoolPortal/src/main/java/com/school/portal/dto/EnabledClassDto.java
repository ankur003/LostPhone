package com.school.portal.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.school.portal.domain.SectionMaster;

public class EnabledClassDto {

	private String className;

	private Date createdAt;

	private boolean isActive;

	private Long classId;

	private List<SectionMaster> sectionMaster = new ArrayList<>();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<SectionMaster> getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(List<SectionMaster> sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

}
