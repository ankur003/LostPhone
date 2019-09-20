package com.school.portal.service.sectionclass;

import com.school.portal.domain.ClassMaster;
import com.school.portal.dto.SectionClassDto;

public interface SectionClassService {

	public ClassMaster checkAlreadyCreatedClassOrSectionAndSave(SectionClassDto sectionClassDto);

	public ClassMaster checkIsClassExists(String className);

	public ClassMaster disableClassAndSection(ClassMaster classMaster);

}
