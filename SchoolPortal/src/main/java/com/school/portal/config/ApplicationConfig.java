package com.school.portal.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.school.portal.domain.Role;
import com.school.portal.domain.User;
import com.school.portal.domain.app.ClassMaster;
import com.school.portal.domain.app.SectionMaster;
import com.school.portal.enums.AcademicYear;
import com.school.portal.enums.RoleEum;
import com.school.portal.enums.UserType;
import com.school.portal.repo.ClassMasterRepo;
import com.school.portal.repo.UserRepo;
import com.school.portal.utils.SchoolPortalUtils;

@Component
public class ApplicationConfig {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	ClassMasterRepo classMasterRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBean() {
		final DozerBeanMapper dozerBean = new DozerBeanMapper();
		final List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}

	private User createAdmin() {
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
			admin.setIsAdmin(true);
			admin.setIsActive(true);
			admin.setUserUuid(SchoolPortalUtils.getUniqueUuid());
			admin.setCreatedById(1l);
			return userRepo.save(admin);
		}
		return admin;
	}

	@PostConstruct
	private void createClassSection() {
		List<ClassMaster> count = classMasterRepo.findAll();
		if (CollectionUtils.isNotEmpty(count)) {
			return;
		}
		User admin = createAdmin();
		
		ClassMaster classMaster1 = new ClassMaster();
		classMaster1.setAcademicYear(AcademicYear.YEAR_2020_2021);
		classMaster1.setClassName("1st");
		classMaster1.setCreatedById(admin.getId());
		classMaster1.setIsActive(true);
		classMaster1.setSectionMaster(getSectionMaster(classMaster1, admin));
		classMaster1.setCreatedById(1l);
		classMaster1.setClassUuid(SchoolPortalUtils.getUniqueUuid());
		classMasterRepo.save(classMaster1);

		ClassMaster classMaster2 = new ClassMaster();
		 classMaster2.setAcademicYear(AcademicYear.YEAR_2020_2021);
		 classMaster2.setClassName("2nd");
		classMaster2.setCreatedById((admin.getId()));
		classMaster2.setIsActive(true);
		classMaster2.setSectionMaster(getSectionMaster(classMaster2, admin));
		classMaster2.setCreatedById(1l);
		classMaster2.setClassUuid(SchoolPortalUtils.getUniqueUuid());
		classMasterRepo.save(classMaster2);
	}

	private List<SectionMaster> getSectionMaster(ClassMaster classMaster, User user) {
		List<SectionMaster> sectionMasters = new ArrayList<>();
		SectionMaster sectionMaster1 = new SectionMaster();
		sectionMaster1.setAcademicYear(AcademicYear.YEAR_2020_2021);
		sectionMaster1.setClassMaster(classMaster);
		sectionMaster1.setCreatedById(user.getId());
		sectionMaster1.setIsActive(true);
		sectionMaster1.setSectionName("A");
		sectionMaster1.setCreatedById(1l);
		sectionMaster1.setSectionUuid(SchoolPortalUtils.getUniqueUuid());

		SectionMaster sectionMaster2 = new SectionMaster();
		sectionMaster2.setAcademicYear(AcademicYear.YEAR_2020_2021);
		sectionMaster2.setClassMaster(classMaster);
		sectionMaster2.setCreatedById(user.getId());
		sectionMaster2.setIsActive(true);
		sectionMaster2.setSectionName("B");
		sectionMaster2.setCreatedById(1l);
		sectionMaster2.setSectionUuid(SchoolPortalUtils.getUniqueUuid());

		sectionMasters.add(sectionMaster1);
		sectionMasters.add(sectionMaster2);
		return sectionMasters;
	}
}
