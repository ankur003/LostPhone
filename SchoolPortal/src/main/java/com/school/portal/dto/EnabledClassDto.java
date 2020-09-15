package com.school.portal.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.school.portal.domain.app.SectionMaster;

public class EnabledClassDto {

	private String className;

	private LocalDateTime createdAt;

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<SectionMaster> getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(List<SectionMaster> sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

}
