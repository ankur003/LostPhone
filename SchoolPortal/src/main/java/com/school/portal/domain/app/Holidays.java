package com.school.portal.domain.app;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.school.portal.domain.base.AbstractTemporalDomain;

@Entity
public class Holidays extends AbstractTemporalDomain{

	private static final long serialVersionUID = 2555582299415938793L;

	@NotNull
	@Column(unique = true)
	private Date holidayDate;

	private String holidayDescription;

	@NotNull
	@Column(unique = true)
	private String holidayUuid = UUID.randomUUID().toString() + new Date().getTime();

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getHolidayDescription() {
		return holidayDescription;
	}

	public void setHolidayDescription(String holidayDescription) {
		this.holidayDescription = holidayDescription;
	}

	public String getHolidayUuid() {
		return holidayUuid;
	}

	public void setHolidayUuid(String holidayUuid) {
		this.holidayUuid = holidayUuid;
	}

}