package com.school.portal.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.school.portal.domain.base.BaseDomain;

@Entity
public class Attendance extends BaseDomain {

	private static final long serialVersionUID = -766109500989031562L;
	
	@ManyToOne
	private User user;
	
	private Boolean isAbsent;
	
	private LocalDate absentDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
