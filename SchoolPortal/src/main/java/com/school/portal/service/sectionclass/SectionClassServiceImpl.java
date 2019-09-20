package com.school.portal.service.sectionclass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.ClassMaster;
import com.school.portal.domain.SectionMaster;
import com.school.portal.dto.SectionClassDto;
import com.school.portal.repo.classmaster.ClassMasterRepo;
import com.school.portal.repo.sectionmaster.SectionRepo;

@Service
public class SectionClassServiceImpl implements SectionClassService {

	@Autowired
	ClassMasterRepo classMasterRepo;

	@Autowired
	SectionRepo sectionRepo;

	@Override
	public ClassMaster checkAlreadyCreatedClassOrSectionAndSave(SectionClassDto sectionClassDto) {
		ClassMaster classMaster = classMasterRepo.findByClassNameAndIsActive(sectionClassDto.getClassName(), true);
		if (Objects.isNull(classMaster)) {
			classMaster = new ClassMaster();
			classMaster.setClassName(sectionClassDto.getClassName());
			classMaster.setCreatedAt(new Date());
			List<SectionMaster> list = new ArrayList<>();
			if (sectionClassDto.getSectionNames() != null && !sectionClassDto.getSectionNames().isEmpty()) {
				for (String sectionName : sectionClassDto.getSectionNames()) {
					SectionMaster newSectionMaster = new SectionMaster();
					newSectionMaster.setCreatedAt(new Date());
					newSectionMaster.setIsActive(true);
					newSectionMaster.setSectionName(sectionName);
					newSectionMaster.setClassMaster(classMaster);
					list.add(newSectionMaster);
				}
				classMaster.setSectionMaster(list);
				classMaster = classMasterRepo.save(classMaster);
			}
		}
		if (sectionClassDto.getSectionNames() != null && !sectionClassDto.getSectionNames().isEmpty()) {
			for (String sectionName : sectionClassDto.getSectionNames()) {
				SectionMaster sectionMaster = sectionRepo.findBySectionNameAndClassMaster(sectionName, classMaster);
				if (Objects.isNull(sectionMaster)) {
					sectionMaster = new SectionMaster();
					sectionMaster.setClassMaster(classMaster);
					sectionMaster.setCreatedAt(new Date());
					sectionMaster.setIsActive(true);
					sectionMaster.setSectionName(sectionName);
					sectionRepo.save(sectionMaster);
				}
			}
		}
		return classMaster;
	}

	@Override
	public ClassMaster checkIsClassExists(String className) {
		return classMasterRepo.findByClassNameAndIsActive(className, true);
	}

	@Override
	public ClassMaster disableClassAndSection(ClassMaster classMaster) {
		classMaster.setIsActive(false);
		List<SectionMaster> sectionList = classMaster.getSectionMaster();
		for (SectionMaster section : sectionList) {
			section.setIsActive(false);
		}
		return classMasterRepo.save(classMaster);
	}
}
