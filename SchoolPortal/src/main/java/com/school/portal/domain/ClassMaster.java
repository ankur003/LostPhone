package com.school.portal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClassMaster implements Serializable {

	private static final long serialVersionUID = 613805964039887170L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classId;

	@Column(unique = true)
	private String className;

	@OneToMany(mappedBy = "classMaster" , cascade=CascadeType.ALL)
	private List<SectionMaster> sectionMaster = new ArrayList<>();

	private Boolean isActive = true;

	private String createdOn;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public List<SectionMaster> getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(List<SectionMaster> sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

}
