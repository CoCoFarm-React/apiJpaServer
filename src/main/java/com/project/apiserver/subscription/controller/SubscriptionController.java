package com.project.apiserver.subscription.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.member.dto.MemberAccountDTO;
import com.project.apiserver.member.service.MemberService;
import com.project.apiserver.subscription.service.SubscriptionService;

import lombok.RequiredArgsConstructor;


@Controller
@RestController
@RequestMapping("/api/sub/")
@RequiredArgsConstructor

public class SubscriptionController {

    private final MemberService memberService;
    private final SubscriptionService subService;

    @PostMapping("{tomno}")
    public Map<String, String> addSubscription(MemberAccountDTO fromAccount,
            @PathVariable("tomno") Long tomno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(fromAccount.getEmail());

        subService.incrementSub(dto.getMno(), tomno);

        return Map.of("result", "Success");

    }

    @DeleteMapping("{tomno}")
    public Map<String, String> deleteSubscription(MemberAccountDTO fromAccount,
            @PathVariable("tomno") Long tomno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(fromAccount.getEmail());

        subService.deleteSub(dto.getMno(), tomno);

        return Map.of("result", "Success");

    }
    @GetMapping("{tomno}")
    public Long countSubscription(@PathVariable("tomno") Long tomno){

        return subService.countSub(tomno);
    }
    @GetMapping("{frommno}/list")
    public PageResponseDTO<MemberAccountDTO> getListFrom(@PathVariable("frommno") Long frommno, PageRequestDTO pageRequestDTO){

        return subService.getListfrom(frommno, pageRequestDTO);
    }
    @GetMapping("{tomno}/check")
    public Long check(MemberAccountDTO fromAccount,
            @PathVariable("tomno") Long tomno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(fromAccount.getEmail());

       
        return subService.checkSub(dto.getMno(), tomno);

       

    }
}
