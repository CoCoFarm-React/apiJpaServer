package com.project.apiserver.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.member.dto.MemberAccountDTO;
import com.project.apiserver.member.service.MemberService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
@CrossOrigin
public class AdminMemberContoller {


    private final MemberService memberService;


    @GetMapping("farmer")
    public List<MemberAccountDTO> getFarmerList(){

        // MemberAccountRole role= MemberAccountRole.FARMER;

        // return memberService.getList(role);
        return null;
    }

    @GetMapping("consumer")
    public List<MemberAccountDTO> getConsumerList(){

        //return memberService.getList(role);
        return null;
    }


    @GetMapping("memberOne")
    public MemberAccountDTO getFarmerOne(Long mno){

         return memberService.getOne(mno);
    }    
}
