package com.project.in.demo;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.project.in.demo.domainmssql.SecSql;
import com.project.in.demo.domainmyfsql.FirstSql;
import com.project.in.demo.mysql1.IMysql1;
import com.project.in.demo.mysql2.IMysql2;

@ComponentScan("com.project.in.demo")
@SpringBootApplication
public class DemoApplication {

	@Autowired
	IMysql1 IMysql1;

	@Autowired
	IMysql2 IMysql2;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "1183"));
		app.run(args);
	}

	@PostConstruct
	public void test() {

		FirstSql firstSql = new FirstSql();
		firstSql.setFirstName("ffname");

		IMysql1.save(firstSql);

		SecSql secSql = new SecSql();
		secSql.setFirstName("sfname");
		IMysql2.save(secSql);
	}

}
