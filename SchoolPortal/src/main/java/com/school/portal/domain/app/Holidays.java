package com.school.portal.domain.app;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.school.portal.domain.base.BaseDomain;

@Entity
public class Holidays extends BaseDomain {

	private static final long serialVersionUID = 2555582299415938793L;

	@NotNull
	@Column(unique = true)
	private LocalDate holidayDate;

	private String holidayDescription;

	@NotNull
	@Column(unique = true)
	private String holidayUuid = UUID.randomUUID().toString();

	public LocalDate getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(LocalDate holidayDate) {
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