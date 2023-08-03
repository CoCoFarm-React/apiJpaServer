package com.project.apiserver.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.member.dto.MemberDTO;
import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.service.MemberService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
@CrossOrigin
public class AdminMemberContoller {


    private final MemberService memberService;


    @GetMapping("farmer")
    public List<MemberDTO> getFarmerList(){

        MemberRole role= MemberRole.FARMER;

        return memberService.getList(role);
    }

    @GetMapping("consumer")
    public List<MemberDTO> getConsumerList(){

         MemberRole role= MemberRole.CONSUMER;

         return memberService.getList(role);
    }


    @GetMapping("memberOne")
    public MemberDTO getFarmerOne(Long mno){

         return memberService.getOne(mno);
    }    
}
