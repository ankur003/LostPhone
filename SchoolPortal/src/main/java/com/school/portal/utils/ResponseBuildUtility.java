package com.school.portal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.school.portal.domain.ClassMaster;
import com.school.portal.domain.SectionMaster;

public class ResponseBuildUtility {

	private ResponseBuildUtility() {
		//
	}

	public static Map<String, Object> buildCreatedClassResponse(ClassMaster createdClassDetails) {
		Map<String, Object> map = new HashMap<>();
		map.put("className", createdClassDetails.getClassName());
		map.put("classId", createdClassDetails.getClassId());
		map.put("createdAt", createdClassDetails.getCreatedAt());
		List<SectionMaster> sectionList = createdClassDetails.getSectionMaster();
		List<String> listOfSectionName = new ArrayList<>();
		for (SectionMaster sectionMaster : sectionList) {
			listOfSectionName.add(sectionMaster.getSectionName());
		}
		map.put("sectionName", listOfSectionName);
		return map;
	}

}
