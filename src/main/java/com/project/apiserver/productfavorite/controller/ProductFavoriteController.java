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
    public Map<String, String> addfavorite(MemberAccountDTO account,
            @PathVariable("pno") Long pno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(account.getEmail());

        pFavoriteService.incrementFavorite(dto.getMno(), pno);

        return Map.of("result", "Success");

    }

    @DeleteMapping("{pno}/{email}")
    public Map<String, String> deletefavorite(@PathVariable("email") String account,
            @PathVariable("pno") Long pno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(account);

        pFavoriteService.deleteFavorite(dto.getMno(), pno);

        return Map.of("result", "Success");

    }

    @GetMapping("{pno}")
    public Long countfavorite(@PathVariable("pno") Long pno) {

        return pFavoriteService.countFavorite(pno);
    }

    @GetMapping("{pno}/check")
    public Long checkfavorite(MemberAccountDTO account,
            @PathVariable("pno") Long pno) {

        MemberAccountDTO dto = memberService.getInfoByEmail(account.getEmail());

        return pFavoriteService.checkFavorite(pno, dto.getMno());
    }
}
