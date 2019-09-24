package com.school.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsernameAndIsActive(String username, boolean isActive);


}
