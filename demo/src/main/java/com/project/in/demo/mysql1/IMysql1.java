package com.project.in.demo.mysql1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.in.demo.domainmyfsql.FirstSql;

@Repository
public interface IMysql1 extends JpaRepository<FirstSql, Long> {

}
