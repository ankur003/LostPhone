package com.school.portal.domain.composite;
import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.school.portal.enums.AcademicYear;

public class ClassMasterIdentity implements Serializable {

	private static final long serialVersionUID = -6618147263678395286L;
	
	private String className;
	
	@Enumerated(EnumType.STRING)
	private AcademicYear academicYear;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
}