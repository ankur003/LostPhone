package com.project.in.demo.conig;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.project.in.demo.mysql2", entityManagerFactoryRef = "productEntityManager", transactionManagerRef = "productTransactionManager")
public class ProductConfig {

	@Value("${spring.second-datasource.jdbc.driverClassName}")
	private String className;

	@Value("${spring.second-datasource.jdbcUrl}")
	private String jdbcUrl;

	@Value("${spring.second-datasource.username}")
	private String dbUserName;

	@Value("${spring.second-datasource.password}")
	private String dbPassword;

	@Bean
	public LocalContainerEntityManagerFactoryBean productEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(productDataSource());
		em.setPackagesToScan(new String[] { "com.project.in.demo.domainmssql" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource productDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(className);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager productTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(productEntityManager().getObject());
		return transactionManager;
	}
}