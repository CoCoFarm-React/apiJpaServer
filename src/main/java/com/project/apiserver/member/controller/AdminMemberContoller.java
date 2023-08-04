package com.project.apiserver.member.controller;


import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.member.dto.MemberAccountDTO;
import com.project.apiserver.member.dto.MemberPageRequestDTO;
import com.project.apiserver.member.dto.MemberPageResponseDTO;
import com.project.apiserver.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
@CrossOrigin
public class AdminMemberContoller {


    private final MemberService memberService;


    @GetMapping("farmer")
    public MemberPageResponseDTO<MemberAccountDTO> getFarmerList(@ParameterObject MemberPageRequestDTO memberPageRequestDTO){

        memberPageRequestDTO.setRoleName("FARMER"); 
        
        return memberService.getMemberList(memberPageRequestDTO);

    }

    @GetMapping("consumer")
    public MemberPageResponseDTO<MemberAccountDTO> getConsumerList(@ParameterObject MemberPageRequestDTO pageRequestDTO){

        pageRequestDTO.setRoleName("CONSUMER");
        
        return memberService.getMemberList(pageRequestDTO);
    }

    @PostMapping("")
    public Map<String, String> registerMember(@RequestBody MemberAccountDTO accountDTO){

        memberService.registerMember(accountDTO);

        return Map.of("result", "succeess");

    }


    @GetMapping("read/{mno}")
    public MemberAccountDTO getFarmerOne(@PathVariable Long mno){

         return memberService.getOne(mno);
    }    


    @DeleteMapping("{mno}")
    public Map<String, String> deleteMember(@PathVariable Long mno) {

        
        memberService.deleteMember(mno);

        return Map.of("result","succeess"); 
    }

    @PutMapping("modify")
    public Map<String, String> modifyMember(@RequestBody MemberAccountDTO accountDTO){

        memberService.modifyMember(accountDTO);

        return Map.of("result", "succeess");

    }
    


}
