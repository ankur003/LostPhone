package com.school.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.school.portal.domain.base.BaseDomain;
import com.school.portal.enums.RoleEum;

@Entity
public class Role extends BaseDomain {

	private static final long serialVersionUID = 7189961001551880900L;

	@Enumerated(EnumType.STRING)
	private RoleEum name;

	@Column
	private String description;

	public RoleEum getName() {
		return name;
	}

	public void setName(RoleEum name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
