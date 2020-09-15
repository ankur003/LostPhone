package com.school.portal.model.response;

public class SectionMasterModel extends BaseModel {

	private static final long serialVersionUID = -1802728402545451329L;

	private String sectionName;
	
	private String sectionUuid;
	
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionUuid() {
		return sectionUuid;
	}

	public void setSectionUuid(String sectionUuid) {
		this.sectionUuid = sectionUuid;
	}

}
