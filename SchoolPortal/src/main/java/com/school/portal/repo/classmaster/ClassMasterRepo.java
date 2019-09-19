package com.school.portal.repo.classmaster;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.ClassMaster;

public interface ClassMasterRepo extends JpaRepository<ClassMaster, Long> {

	ClassMaster findByClassName(String className);

}
