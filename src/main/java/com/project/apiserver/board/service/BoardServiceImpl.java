package com.project.apiserver.board.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.dto.BoardReadDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.repository.BoardRepository;
import com.project.apiserver.common.Category;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.member.entity.MemberAccount;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public PageResponseDTO<BoardListDTO> getList(PageRequestDTO pageRequestDTO) {
        
        return boardRepository.search(pageRequestDTO);
    }

    @Override
    public BoardReadDTO getOne(Long bno) {
        boardRepository.incrementView(bno);
        log.info("GET read................................");
        List<BoardReadDTO> readList =boardRepository.selectOne(bno);
        
        BoardReadDTO dto = BoardReadDTO
        .builder()
        .bno(readList.get(0).getBno())
        .title(readList.get(0).getTitle())
        .content(readList.get(0).getContent())
        .email(readList.get(0).getEmail())
        .nickname(readList.get(0).getNickname())
        .catename(readList.get(0).getCatename())
        .cateno(readList.get(0).getCateno())
        .mno(readList.get(0).getMno())
        .regDate(readList.get(0).getRegDate())
        .modDate(readList.get(0).getModDate())
        .delFlag(readList.get(0).isDelFlag())
        .fname(String.join(",", readList.stream().map(data -> data.getFname()).collect(Collectors.toList())))
        .view(readList.get(0).getView())
        .build();

        return dto;
        
    }

    @Override
    public void registBoard(BoardReadDTO boardReadDTO) {
        log.info("service11111111111111111111111111111111111111111111111");
        // Board board = modelMapper.map(boardReadDTO, Board.class);
        Category dtoCategory = Category.builder().cateno(boardReadDTO.getCateno()).catename(boardReadDTO.getCatename()).build();
        MemberAccount accountDTO = MemberAccount.builder().mno(boardReadDTO.getMno()).build();
        
        


        Board board = Board.builder()
        .title(boardReadDTO.getTitle())
        .content(boardReadDTO.getContent())
        .category(dtoCategory)
        .member(accountDTO)
        .view(boardReadDTO.getView())
        .build();

        log.info("Mapping data");
        boardRepository.save(board);
    }

    

    @Override
    public void deleteBoard(Long bno) {

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        board.changeDelFlag(true);
        board.changeContent("삭제된 게시물 입니다.");
        board.changeTitle("삭제된 게시물 입니다.");

        boardRepository.save(board);


    }

    @Override
    public void modifyBoard(BoardReadDTO boardReadDTO) {

        Optional<Board> result = boardRepository.findById(boardReadDTO.getBno());

        Board board = result.orElseThrow();

        board.changeContent(boardReadDTO.getContent());
        board.changeTitle(boardReadDTO.getTitle());

        boardRepository.save(board);
        
    }

    @Override
    public PageResponseDTO<BoardListDTO> getListSameWriter(Long mno, PageRequestDTO pageRequestDTO) {
        
        return boardRepository.searchSameWriter(mno, pageRequestDTO);
    }

    

}
