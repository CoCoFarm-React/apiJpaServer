package com.project.apiserver.board.service;


import java.util.Optional;

import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;
    
    @Override
    public PageResponseDTO<BoardListDTO> getList(PageRequestDTO pageRequestDTO) {
        
        return boardRepository.search(pageRequestDTO);
    }

    @Override
    public BoardReadDTO getOne(Long bno) {

       

       //BoardListDTO board = boardRepository.getBoard(bno);

        return boardRepository.getBoardInfo(bno);
        
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
