package com.school.portal.model.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ClassSectionCreationModel {

	@NotBlank(message = "className is in invalid format or missing")
	private String className;

	@NotEmpty(message = "sectionNames is in invalid format or missing")
	private Set<String> sectionNames;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<String> getSectionNames() {
		return sectionNames;
	}

	public void setSectionNames(Set<String> sectionNames) {
		this.sectionNames = sectionNames;
	}

}
