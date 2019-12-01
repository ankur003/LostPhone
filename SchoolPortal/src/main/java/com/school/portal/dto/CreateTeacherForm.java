package com.school.portal.dto;

import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class CreateTeacherForm {

	@NotBlank(message = "teacherName is  null")
	private String teacherName;

	@NotBlank(message = "email is null")
	private String email;

//	private Date doj;
//
//	private Date dob;

	private boolean isClassTeacher;

	private Map<String, Set<String>> teacherClassSectionMap;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

//	public Date getDoj() {
//		return doj;
//	}
//
//	public void setDoj(Date doj) {
//		this.doj = doj;
//	}

	public boolean isClassTeacher() {
		return isClassTeacher;
	}

	public void setClassTeacher(boolean isClassTeacher) {
		this.isClassTeacher = isClassTeacher;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}

	public Map<String, Set<String>> getTeacherClassSectionMap() {
		return teacherClassSectionMap;
	}

	public void setTeacherClassSectionMap(Map<String, Set<String>> teacherClassSectionMap) {
		this.teacherClassSectionMap = teacherClassSectionMap;
	}
}
