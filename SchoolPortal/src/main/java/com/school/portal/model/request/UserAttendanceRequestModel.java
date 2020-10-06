package com.school.portal.model.request;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class UserAttendanceRequestModel {

	@ApiModelProperty(required = false, value = "specificDate")
	@Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "specificDate : specificDate is invalid")
	private String specificDate;

	@ApiModelProperty(required = false, value = "startDate [yyyy-mm-dd]")
	@Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "startDate : specificDate is invalid")
	private String startDate;

	@ApiModelProperty(required = false, value = "endDate [yyyy-mm-dd]")
	@Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "endDate : specificDate is invalid")
	private String endDate;

	public String getSpecificDate() {
		return specificDate;
	}

	public void setSpecificDate(String specificDate) {
		this.specificDate = specificDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
