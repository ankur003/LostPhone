package com.school.portal.utils;

import java.util.List;
import java.util.UUID;

import com.school.portal.domain.app.SectionMaster;

public final class SchoolPortalUtils {
	
	private SchoolPortalUtils() {
		//
	}

	public static boolean checkIsSectionExistsInClass(List<SectionMaster> sectionList, String sectionName) {
		for (SectionMaster sectionMaster : sectionList) {
			return sectionMaster.getSectionName().equalsIgnoreCase(sectionName) && sectionMaster.getIsActive();
		}
		return false;
	}
	
	public static final String getUniqueUuid() {
		return UUID.randomUUID().toString();
	}
}
