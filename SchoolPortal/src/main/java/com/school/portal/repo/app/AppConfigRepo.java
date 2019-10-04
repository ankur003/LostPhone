package com.school.portal.repo.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.app.LoginCountConfig;

public interface AppConfigRepo extends JpaRepository<LoginCountConfig, Long> {

	LoginCountConfig findByIsLoginCountActive(boolean isLoginCountActive);

}
