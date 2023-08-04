package com.project.apiserver.member.service;

import java.util.Optional;

import com.project.apiserver.member.entity.MemberAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.apiserver.member.dto.MemberAccountDTO;
import com.project.apiserver.member.dto.MemberPageRequestDTO;
import com.project.apiserver.member.dto.MemberPageResponseDTO;
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
    public MemberAccountDTO getOne(Long mno) {

        Optional<MemberAccount> optionalMember = repository.findById(mno);

        MemberAccount memberember = optionalMember.orElseThrow();
        log.info("-==========================");
        log.info(memberember);
        log.info("-==========================");
        // Member(mno=50, email=aaa49@email.com, pw=1111, nickname=nickname49, intro=차은우 짱50)
        MemberAccountDTO dto = modelMapper.map(memberember, MemberAccountDTO.class);

        return dto;

    }



    @Override
    public MemberPageResponseDTO<MemberAccountDTO> getMemberList(MemberPageRequestDTO memberPageRequestDTO) {



        return repository.search(memberPageRequestDTO);

    }



    @Override
    public void deleteMember(Long mno) {

    }



    @Override
    public void modifyMember(MemberAccountDTO memberAccountDTO) {

    }

   
}
