package com.project.apiserver.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
    
    @Autowired(required = false)
    MemberService service;

    @Test
    @Transactional
    public void getList(){
        String value = "FARMER";

        MemberRole role = MemberRole.valueOf(value);
       log.info(service.getList(role)); 
    }


    ///api/admin/memberOne
    @Test
    @Transactional
    public void getOneTest(){
        log.info(service.getOne(50L)); 
    }
    
}

