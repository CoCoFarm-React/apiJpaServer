package com.project.apiserver.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.member.entity.MemberAccount;
import com.project.apiserver.subscription.repository.SubscriptionRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SubscriptionRepositoryTests {
    
    @Autowired(required = false)
    private SubscriptionRepository subRepository;


    @Test
    public void insertSubTest(){
        MemberAccount toAccount = MemberAccount.builder().mno(483L).build();


        for(int i=2; i<200; i++){
            if(i%2==0)
            {
            Long value = (long) i;
            log.info(i);
            MemberAccount fromAccount = MemberAccount.builder().mno(value).build();
            subRepository.insertSubscriptionNative(fromAccount.getMno(), toAccount.getMno());
            }
        }
    }

    @Test
    public void deldeSubTest(){
        MemberAccount toAccount = MemberAccount.builder().mno(483L).build();
        MemberAccount fromAccount = MemberAccount.builder().mno(2L).build();

        subRepository.deleteSubscriptionNative(fromAccount.getMno(), toAccount.getMno());
        
    }

    @Test
    public void countSubTest(){
        MemberAccount toAccount = MemberAccount.builder().mno(483L).build();

        log.info(subRepository.countSub(toAccount.getMno()));

        
    }

}
