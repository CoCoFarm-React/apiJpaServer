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
    // Read table one row
    @Override
    public MemberAccountDTO getOne(Long mno) {

        Optional<MemberAccount> result = repository.findById(mno);

        MemberAccount member = result.orElseThrow();
        log.info("-==========================");
        log.info(member);
        log.info("-==========================");
        // Member(mno=50, email=aaa49@email.com, pw=1111, nickname=nickname49, intro=차은우 짱50)
        MemberAccountDTO dto = modelMapper.map(member, MemberAccountDTO.class);

        return dto;

    }


    // read table list with search and pagination
    @Override
    public MemberPageResponseDTO<MemberAccountDTO> getMemberList(MemberPageRequestDTO memberPageRequestDTO) {



        return repository.search(memberPageRequestDTO);

    }



    @Override
    public void deleteMember(Long mno) {

        Optional<MemberAccount> result = repository.findById(mno);

        MemberAccount member =  result.orElseThrow();
        
        member.delete();

        repository.save(member);
        
    }



    @Override
    public void modifyMember(MemberAccountDTO memberAccountDTO) {

        log.info("mno------------------------------");
        log.info(memberAccountDTO);

        Optional<MemberAccount> result =repository.findById(memberAccountDTO.getMno());

        log.info("modify service1.......................");

        MemberAccount member =  result.orElseThrow();

        log.info("modify service.2......................");

        member.changeNickname(memberAccountDTO.getNickname());
        member.changePw(memberAccountDTO.getPw());
        member.changeIntro(memberAccountDTO.getIntro());
        member.changeAddress(memberAccountDTO.getAddress());
        member.changeSocialFalse();
        log.info("modify service3 --------------");
        repository.save(member);
        
    }


    @Override
    public void registerMember(MemberAccountDTO accountDTO) {

        Optional<MemberAccount> memberAccount = repository.findById(accountDTO.getMno());
        MemberAccount account = memberAccount.orElseThrow();

        account.changeIntro(accountDTO.getIntro());
        account.changeNickname(accountDTO.getNickname());
        account.changePw(accountDTO.getPw());
        account.changeSocialFalse();
        account.changeAddress(accountDTO.getAddress());

        repository.save(account);

    }

   
}
