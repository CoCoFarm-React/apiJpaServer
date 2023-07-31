package com.project.apiserver.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.entity.QBoard;
import com.project.apiserver.board.repository.BoardRepository;
import com.project.apiserver.common.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BoardListDTO> getBoardList() {

        // List <Board> board = boardRepository.getBoardList();
        // List <BoardListDTO> result = board.stream().map(dto-> modelMapper.map(dto, BoardListDTO.class)).collect(Collectors.toList());
        // List<Board> boardList =  boardRepository.findAll();
        // return boardList.stream().map(dto-> modelMapper.map(dto, BoardListDTO.class)).collect(Collectors.toList());
        return null;

    }
    
}
