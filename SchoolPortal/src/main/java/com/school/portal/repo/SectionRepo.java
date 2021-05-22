package com.school.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.app.SectionMaster;

public interface SectionRepo extends JpaRepository<SectionMaster, Long> {

	//SectionMaster findBySectionNameAndClassMaster(String sectionName, ClassMaster classMaster);
}
