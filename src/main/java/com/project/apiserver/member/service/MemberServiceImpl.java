package com.project.apiserver.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.apiserver.member.dto.MemberDTO;
import com.project.apiserver.member.entity.Member;
import com.project.apiserver.member.entity.MemberRole;
import com.project.apiserver.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final MemberRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public List<MemberDTO> getList(MemberRole memberRole) {

        List<Member> result = repository.findByRole(memberRole);

        List<MemberDTO> list = result.stream().map(dto -> modelMapper.map(dto, MemberDTO.class))
        .collect(Collectors.toList());

        return list;
    }

   
}
