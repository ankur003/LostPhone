package com.project.in.demo.mysql2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.in.demo.domainmssql.SecSql;

@Repository
public interface IMysql2 extends JpaRepository<SecSql, Long> {

}
