package com.project.apiserver.board.service;

import java.util.List;

import com.project.apiserver.board.dto.BoardListDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardService {

    List<BoardListDTO> getBoardList();
    
}
