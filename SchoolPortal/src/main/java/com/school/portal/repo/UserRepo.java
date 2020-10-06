package com.school.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.User;
import com.school.portal.enums.AcademicYear;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsernameAndIsActive(String username, Boolean isActive);

	User findByUserUuidAndAcademicYearAndIsActive(String userUuid, AcademicYear academicYear, Boolean isActive);


}
