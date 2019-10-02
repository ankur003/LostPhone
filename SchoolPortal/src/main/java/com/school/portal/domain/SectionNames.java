package com.school.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SectionNames {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private ClassNames classNames;

	private String sectionName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClassNames getClassNames() {
		return classNames;
	}

	public void setClassNames(ClassNames classNames) {
		this.classNames = classNames;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

}
