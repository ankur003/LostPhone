package com.school.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.app.ClassMaster;

public interface ClassMasterRepo extends JpaRepository<ClassMaster, Long> {

//	ClassMaster findByClassNameAndIsActive(String className, boolean isActive);
//
     ClassMaster findByClassName(String className);
}
