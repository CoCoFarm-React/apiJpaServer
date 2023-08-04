package com.project.apiserver.member.repository;


import com.project.apiserver.member.entity.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;


import com.project.apiserver.member.repository.search.MemberSearch;

public interface MemberRepository extends JpaRepository<MemberAccount, Long>, MemberSearch{

    
    

}
