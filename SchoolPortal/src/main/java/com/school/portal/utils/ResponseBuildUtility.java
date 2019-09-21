package com.school.portal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.portal.domain.ClassMaster;
import com.school.portal.domain.SectionMaster;
import com.school.portal.dto.EnabledClassDto;

public class ResponseBuildUtility {

	private ResponseBuildUtility() {
		//
	}

	public static Map<String, Object> buildClassResponse(ClassMaster classDetails) {
		Map<String, Object> map = new HashMap<>();
		map.put("className", classDetails.getClassName());
		map.put("classId", classDetails.getClassId());
		map.put("createdAt", classDetails.getCreatedAt());
		map.put("isActive", classDetails.getIsActive());
		List<SectionMaster> sectionList = classDetails.getSectionMaster();
		List<String> listOfSectionName = new ArrayList<>();
		for (SectionMaster sectionMaster : sectionList) {
			if (sectionMaster.getIsActive()) {
				listOfSectionName.add(sectionMaster.getSectionName());
			}
		}
		map.put("sectionName", listOfSectionName);
		return map;
	}

	public static Map<String, Object> buildClassResponse(List<ClassMaster> classDetailsList) {
		Map<String, Object> map = new HashMap<>();
		for (ClassMaster classMaster : classDetailsList) {
			List<SectionMaster> sectionList = classMaster.getSectionMaster();
			List<String> listOfSectionName = new ArrayList<>();
			for (SectionMaster sectionMaster : sectionList) {
				if (sectionMaster.getIsActive()) {
					listOfSectionName.add(sectionMaster.getSectionName());
				}
			}
			map.put(classMaster.getClassName(), listOfSectionName);
		}
		return map;
	}

	public static Map<String, Object> buildEnableClassAndSectionResponse(List<ClassMaster> classDetailsList) {
		Map<String, Object> map = new HashMap<>();
		for (ClassMaster classMaster : classDetailsList) {
			if (Boolean.TRUE.equals(classMaster.getIsActive())) {
				EnabledClassDto classDto = new EnabledClassDto();
				classDto.setActive(classMaster.getIsActive());
				classDto.setClassName(classMaster.getClassName());
				classDto.setCreatedAt(classMaster.getCreatedAt());
				classDto.setClassId(classMaster.getClassId());
				List<SectionMaster> sectionMaster = classMaster.getSectionMaster();
				for (SectionMaster section : sectionMaster) {
					if (Boolean.TRUE.equals(section.getIsActive())) {
						classDto.setSectionMaster(sectionMaster);
					}
				}
				map.put(classMaster.getClassName(), classDto);
			}
		}
		return map;
	}
}
