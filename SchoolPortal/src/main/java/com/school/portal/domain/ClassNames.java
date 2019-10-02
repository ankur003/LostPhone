package com.school.portal.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ClassNames {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private User user;

	private String className;

	@OneToMany(mappedBy = "classNames", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<SectionNames> sectionNames = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
