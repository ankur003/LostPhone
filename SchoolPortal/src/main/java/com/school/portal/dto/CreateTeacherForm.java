package com.school.portal.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class CreateTeacherForm {

	@NotBlank(message = "teacherName is  null")
	private String teacherName;

	@NotBlank(message = "email is null")
	private String email;

	private Date doj;

	private Date dob;

	private boolean isClassTeacher;

	@NotBlank(message = "className is  null")
	private String className;

	@NotBlank(message = "sectionName is  null")
	private String sectionName;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public boolean isClassTeacher() {
		return isClassTeacher;
	}

	public void setClassTeacher(boolean isClassTeacher) {
		this.isClassTeacher = isClassTeacher;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
