package com.project.apiserver.repository;


import com.project.apiserver.member.entity.MemberAccount;
import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import jakarta.transaction.Transactional;






@SpringBootTest

public class MemberRepositoryTests {
    
    @Autowired
    private MemberRepository repository;

    @Test
    public void insertTest(){

        for(int i = 0; i<100; i++){
        MemberAccount member = MemberAccount.builder()
        .email("aaa" +i+"@email.com")
        .pw("1111")
        .nickname("nickname"+ i)
        .intro("자소개" + i)
        .build();

        switch(i%2){

            case 0:
                member.addRole(MemberRole.FARMER);
            break;
            case 1:
                member.addRole(MemberRole.CONSUMER);
            break;
        }
        
        repository.save(member);
        }
    }


    @Test
    @Transactional
    public void readTest(){

        // List<MemberAccount> list = repository.findAll();
        // log.info(list);
        // log.info("----------");
        // list.forEach(mb ->log.info(mb.getRole()));
        
        //List<MemberAccount> list = repository.findByRole(MemberAccountRole.CONSUMER);

        //log.info(list);
        //list.forEach(MemberAccount->log.info(MemberAccount.getRole()));
    }


    // @Test
    // @Transactional
    // public void getSearchList(){

    //     MemberPageRequestDTO MemberAccountPageRequestDTO = new MemberPageRequestDTO(1,10);

    //     repository.searchMember();
    
    // }
}
