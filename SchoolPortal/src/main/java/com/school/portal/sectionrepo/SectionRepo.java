package com.school.portal.sectionrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.SectionMaster;

public interface SectionRepo extends JpaRepository<SectionMaster, Long> {

}
