package com.project.apiserver.m2.repository;

import com.project.apiserver.m2.entity.Member2;
import com.project.apiserver.m2.repository.search.Member2Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Member2Repository extends JpaRepository<Member2, Long>, Member2Search {
}
