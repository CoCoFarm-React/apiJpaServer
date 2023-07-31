package com.project.apiserver.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.member.entity.Member;
import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    
    @Autowired
    private MemberRepository repository;

    // @Test
    // public void insertTest(){

    //     for(int i = 0; i<100; i++){
    //     Member member = Member.builder()
    //     .email("aaa" +i+"@email.com")
    //     .pw("1111")
    //     .nickname("nickname"+ i)
    //     .build();

    //     switch(i%2){

    //         case 0:
    //         member.addRole(MemberRole.FARMER);
    //         break;
    //         case 1:
    //         member.addRole(MemberRole.CONSUMER);
    //         break;
    //     }
        
    //     repository.save(member);
    //     }
    // }


    @Test
    @Transactional
    public void readTest(){

        // List<Member> list = repository.findAll();
        // log.info(list);
        // log.info("----------");
        // list.forEach(mb ->log.info(mb.getRole()));
        
        List<Member> list = repository.findByRole(MemberRole.CONSUMER);

        log.info(list);
        list.forEach(member->log.info(member.getRole()));
    }
}
