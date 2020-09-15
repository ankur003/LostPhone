package com.school.portal.model.response;

import java.util.List;

public class ClassMasterModel extends BaseModel {

	private static final long serialVersionUID = 6541735192424700998L;

	private String className;
	
	private String classUuid;

	private List<SectionMasterModel> sectionMaster;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<SectionMasterModel> getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(List<SectionMasterModel> sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

	public String getClassUuid() {
		return classUuid;
	}

	public void setClassUuid(String classUuid) {
		this.classUuid = classUuid;
	}
	
}
