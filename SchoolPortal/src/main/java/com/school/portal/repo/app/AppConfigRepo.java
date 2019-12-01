package com.school.portal.repo.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.app.LoginCount;

public interface AppConfigRepo extends JpaRepository<LoginCount, Long> {

	LoginCount findByIsLoginCountActive(boolean isLoginCountActive);

}
