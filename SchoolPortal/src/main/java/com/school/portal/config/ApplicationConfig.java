package com.school.portal.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.school.portal.domain.Role;
import com.school.portal.domain.User;
import com.school.portal.enums.RoleEum;
import com.school.portal.enums.UserType;
import com.school.portal.repo.UserRepo;

@Component
public class ApplicationConfig {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        final DozerBeanMapper dozerBean = new DozerBeanMapper();
        final List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

	@PostConstruct
	private void createAdmin() {
		User admin = userRepo.findByUsernameAndIsActive("admin@schoolportal.com", true);
		if (Objects.isNull(admin)) {
			admin = new User();
			admin.setPassword(encoder.encode("admin"));
			Set<Role> roles = new HashSet<>(); 
			Role role = new Role(); 
			role.setDescription("Admin role for the principle"); 
			role.setName(RoleEum.ADMIN);

			Role role1 = new Role();
			role1.setDescription("Admin role for the principle");
			role1.setName(RoleEum.STUDENT);

			roles.add(role1);
			roles.add(role);
			admin.setRoles(roles);
			admin.setUsername("admin@schoolportal.com");
			admin.setDoj(LocalDate.now());
			admin.setName("principle");
			admin.setUserType(UserType.PRINCIPLE);
			admin.setAdmin(true);
			admin.setActive(true);
			userRepo.save(admin);
		}
	}
}
