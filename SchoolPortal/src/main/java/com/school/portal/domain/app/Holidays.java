package com.school.portal.domain.app;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Holidays {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(unique = true)
	private Date holidayDate;

	private String holidayDescription;

	@NotNull
	@Column(unique = true)
	private String holidayUuid = UUID.randomUUID().toString() + new Date().getTime();

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getHolidayUuid() {
		return holidayUuid;
	}

	public void setHolidayUuid(String holidayUuid) {
		this.holidayUuid = holidayUuid;
	}

}