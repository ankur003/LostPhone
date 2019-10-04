package com.school.portal.service.app;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.app.LoginCountConfig;
import com.school.portal.repo.app.AppConfigRepo;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	AppConfigRepo appConfigRepo;

	@Override
	public LoginCountConfig updateLoginCount(Integer loginCount, boolean isLoginCountActive) {
		List<LoginCountConfig> appConfig = appConfigRepo.findAll();
		if (appConfig.size() == 1) {
			LoginCountConfig details = appConfig.get(0);
			details.setCreatedAt(LocalDateTime.now());
			if (loginCount != null && loginCount > 0) {
				details.setLoginCount(loginCount);
			}
			details.setLoginCountActive(isLoginCountActive);
			return appConfigRepo.save(details);
		}
		return null;
	}
}
