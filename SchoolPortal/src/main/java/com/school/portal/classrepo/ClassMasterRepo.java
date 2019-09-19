package com.school.portal.classrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.ClassMaster;

public interface ClassMasterRepo extends JpaRepository<ClassMaster, Long> {

}
