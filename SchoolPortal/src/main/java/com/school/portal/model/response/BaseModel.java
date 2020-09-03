package com.school.portal.model.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.school.portal.enums.AcademicYear;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1866360907448597333L;

	private AcademicYear academicYear;

	private String createdByUuid;

	private Boolean isActive;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public String getCreatedByUuid() {
		return createdByUuid;
	}

	public void setCreatedByUuid(String createdByUuid) {
		this.createdByUuid = createdByUuid;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
