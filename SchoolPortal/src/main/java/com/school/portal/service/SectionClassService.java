package com.school.portal.service;

import java.util.List;

import com.school.portal.domain.ClassMaster;
import com.school.portal.dto.SectionClassDto;

public interface SectionClassService {

	public ClassMaster checkAlreadyCreatedClassOrSectionAndSave(SectionClassDto sectionClassDto);

	public ClassMaster checkIsClassExists(String className, boolean isActive);

	public ClassMaster disableClassAndSections(ClassMaster classMaster);

	public ClassMaster disablePurticularSection(ClassMaster classMaster, String sectionName);

	public List<ClassMaster> getAllClassAndSections();

	public ClassMaster getSectionsListByClassName(String className);

	public ClassMaster enableClass(ClassMaster classMaster);

	public ClassMaster enableSections(ClassMaster classMaster, List<String> sectionNames);

}
