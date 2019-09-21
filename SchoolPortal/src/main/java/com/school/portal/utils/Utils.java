package com.school.portal.utils;

import java.util.List;

import com.school.portal.domain.SectionMaster;

public class Utils {

	public static boolean checkIsSectionExistsInClass(List<SectionMaster> sectionList, String sectionName) {
		for (SectionMaster sectionMaster : sectionList) {
			return sectionMaster.getSectionName().equalsIgnoreCase(sectionName) && sectionMaster.getIsActive();
		}
		return false;
	}
}
