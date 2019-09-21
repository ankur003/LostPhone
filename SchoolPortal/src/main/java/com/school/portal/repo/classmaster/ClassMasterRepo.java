package com.school.portal.repo.classmaster;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.ClassMaster;

public interface ClassMasterRepo extends JpaRepository<ClassMaster, Long> {

	ClassMaster findByClassNameAndIsActive(String className, boolean isActive);

	ClassMaster findByClassName(String className);
}
