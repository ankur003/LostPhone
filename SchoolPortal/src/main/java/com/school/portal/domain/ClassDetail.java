package com.school.portal.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.portal.domain.base.AbstractTemporalDomain;

@Entity
public class ClassDetail extends AbstractTemporalDomain {

	private static final long serialVersionUID = 1370919601175922061L;

	@ManyToOne
	private User user;

	private String className;

	@OneToMany(mappedBy = "classNames", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<SectionNames> sectionNames = new HashSet<>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<SectionNames> getSectionNames() {
		return sectionNames;
	}

	public void setSectionNames(Set<SectionNames> sectionNames) {
		this.sectionNames = sectionNames;
	}

}
