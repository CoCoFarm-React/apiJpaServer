package com.project.apiserver.member.controller;


import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
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
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
@CrossOrigin
@Log4j2
public class MemberContoller {


    private final MemberService memberService;


    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("farmer")
    public MemberPageResponseDTO<MemberAccountDTO> getFarmerList(@ParameterObject MemberPageRequestDTO memberPageRequestDTO){
        log.info("test");
        memberPageRequestDTO.setRoleName("FARMER"); 
        
        return memberService.getMemberList(memberPageRequestDTO);

    }
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
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

    // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONSUMER','ROLE_FARMER')")
    @GetMapping("read/{mno}")
    public MemberAccountDTO getFarmerOne(@PathVariable Long mno){

         return memberService.getOne(mno);
    }    

    // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CONSUMER','ROLE_FARMER')")
    @DeleteMapping("{mno}")
    public Map<String, String> deleteMember(@PathVariable Long mno) {

        
        memberService.deleteMember(mno);

        return Map.of("result","succeess"); 
    }

    // @PreAuthorize("hasAnyRole('ROLE_CONSUMER','ROLE_FARMER')")
    @PutMapping("modify")
    public Map<String, String> modifyMember(@RequestBody MemberAccountDTO accountDTO){

        memberService.modifyMember(accountDTO);

        return Map.of("result", "succeess");

    }
    


}
