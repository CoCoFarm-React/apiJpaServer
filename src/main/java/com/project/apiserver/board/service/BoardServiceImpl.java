package com.project.apiserver.board.service;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.dto.BoardReadDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.repository.BoardRepository;

import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

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
        
        Board board = modelMapper.map(boardReadDTO, Board.class);

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
