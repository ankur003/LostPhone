package com.school.portal.model.response;

import java.time.LocalDate;

public class AttendanceModel {

	private UserModel user;

	private Boolean isAbsent;

	private LocalDate absentDate;

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Boolean getIsAbsent() {
		return isAbsent;
	}

	public void setIsAbsent(Boolean isAbsent) {
		this.isAbsent = isAbsent;
	}

	public LocalDate getAbsentDate() {
		return absentDate;
	}

	public void setAbsentDate(LocalDate absentDate) {
		this.absentDate = absentDate;
	}

}
