package com.school.portal.repo.sectionmaster;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.ClassMaster;
import com.school.portal.domain.SectionMaster;

public interface SectionRepo extends JpaRepository<SectionMaster, Long> {

	SectionMaster findBySectionNameAndClassMaster(String sectionName, ClassMaster classMaster);
}
