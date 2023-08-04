package com.project.apiserver.repository;


import com.project.apiserver.member.dto.MemberAccountRole;
import com.project.apiserver.member.dto.MemberPageRequestDTO;
import com.project.apiserver.member.entity.MemberAccount;
import com.project.apiserver.member.repository.MemberRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;



@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    
    @Autowired
    private MemberRepository repository;

    @Test
    public void insertTest(){

        for(int i = 0; i<500; i++){
        MemberAccount member = MemberAccount.builder()
        .email("aaa" +i+"@email.com")
        .pw("1111")
        .nickname("nickname"+ i)
        .intro("자소개" + i)
        .build();

        switch(i%2){

            case 0:
                member.changeRole(MemberAccountRole.FARMER);
            break;
            case 1:
                member.changeRole(MemberAccountRole.CONSUMER);
            break;
        }
        
        repository.save(member);
        }
    }
    // 임시 관리자를 넣기위한 관리자
    @Test
    public void insertAdmin(){
         MemberAccount member = MemberAccount.builder()
        .email("aaa" +100+"@email.com")
        .pw("1111")
        .nickname("admin")
        .intro("관리자 소개")
        .roleName(MemberAccountRole.ADMIN.getRoleName())
        .build();

        repository.save(member);
    }


    @Test
    @Transactional
    public void getSearchList(){

       MemberPageRequestDTO page = MemberPageRequestDTO.builder().type("e").keyword("1").build();

       log.info(repository.search(page));

    }

    @Test
    public void getOne(){
      
        MemberAccount one =  repository.getOne(6L);

        log.info(one);
       

    }

    @Test
    @Transactional
    public void getSearchRoleList(){

       MemberPageRequestDTO page = MemberPageRequestDTO.builder().roleName("FARMER").build();

       log.info(repository.search(page));

    }
    
    @Test
    @Transactional
    @Commit
    public void deleteMember(){
        Optional<MemberAccount> result = repository.findById(5L);
        MemberAccount account =result.orElseThrow();
        account.delete();

        repository.save(account);
    }


    @Test
    @Transactional
    @Commit
    public void modifyMember(){

        Optional<MemberAccount> result =repository.findById(5L);
        MemberAccount account = result.orElseThrow();
        account.changeNickname("차은우 술중독자");
        account.changePw("1234567");
        account.changeIntro("본인은 아니라고 하지만 술중독 맞음");
        repository.save(account);

        log.info(account);
    }



    
}
