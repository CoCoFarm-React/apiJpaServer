package com.project.apiserver.member.service;

import java.util.List;
import java.util.Optional;

import com.project.apiserver.member.entity.MemberAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.apiserver.member.dto.MemberDTO;

import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {


    private final MemberRepository repository;
    private final ModelMapper modelMapper;


    
    @Override
    public List<MemberDTO> getList(MemberRole memberRole) {

        // List<Member> result = repository.findByRole(memberRole);

        // List<MemberDTO> list = result.stream().map(dto -> modelMapper.map(dto, MemberDTO.class))
        // .collect(Collectors.toList());

        // return list;
        return null;
    }



    @Override
    public MemberDTO getOne(Long mno) {

        Optional<MemberAccount> optionalMember = repository.findById(mno);

        

        MemberAccount memberember = optionalMember.orElseThrow();
        log.info("-==========================");
        log.info(memberember);
        log.info("-==========================");
        // Member(mno=50, email=aaa49@email.com, pw=1111, nickname=nickname49, intro=차은우 짱50)
        MemberDTO dto = modelMapper.map(memberember, MemberDTO.class);

        return dto;

    }

   
}
