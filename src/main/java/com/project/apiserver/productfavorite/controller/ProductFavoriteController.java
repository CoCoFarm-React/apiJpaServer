package com.project.apiserver.productfavorite.controller;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.apiserver.member.dto.MemberAccountDTO;
import com.project.apiserver.member.service.MemberService;
import com.project.apiserver.productfavorite.service.ProductFavoriteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productfavorite/")
@RequiredArgsConstructor
public class ProductFavoriteController {

    private final MemberService memberService;
    private final ProductFavoriteService pFavoriteService;


    @PostMapping("{pno}")
    public Map<String, String> addSubscription(MemberAccountDTO account,
            @PathVariable("pno") Long pno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(account.getEmail());

        pFavoriteService.incrementFavorite(dto.getMno(), pno);

        return Map.of("result", "Success");

    }

    @DeleteMapping("{pno}")
    public Map<String, String> deleteSubscription(MemberAccountDTO account,
            @PathVariable("pno") Long pno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(account.getEmail());

        pFavoriteService.deleteFavorite(dto.getMno(), pno);

        return Map.of("result", "Success");

    }
    @GetMapping("{bno}")
    public Long countSubscription(@PathVariable("pno") Long pno){

        return pFavoriteService.countFavorite(pno);
    }
}
