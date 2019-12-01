package com.school.portal.service.app;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.app.LoginCount;
import com.school.portal.repo.app.AppConfigRepo;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	AppConfigRepo appConfigRepo;

	@Override
	public LoginCount updateLoginCount(Integer loginCount, boolean isLoginCountActive) {
		List<LoginCount> appConfig = appConfigRepo.findAll();
		if (appConfig.size() == 1) {
			LoginCount details = appConfig.get(0);
			details.setCreatedAt(LocalDateTime.now());
			if (loginCount != null && loginCount > 0) {
				details.setLoginCount(loginCount);
			}
			details.setLoginCountActive(isLoginCountActive);
			return appConfigRepo.save(details);
		}
		return null;
	}

	@Override
	public int getLoginCount() {
		LoginCount appCofing = appConfigRepo.findByIsLoginCountActive(true);
		if (appCofing != null) {
			return appCofing.getLoginCount();
		}
		return 0;
	}
}
