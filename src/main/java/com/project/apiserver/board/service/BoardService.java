package com.project.apiserver.board.service;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.dto.BoardReadDTO;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardService {

   PageResponseDTO<BoardListDTO> getList(PageRequestDTO pageRequestDTO);

   BoardReadDTO getOne(Long bno);

   void registBoard(BoardReadDTO boardReadDTO);

   //삭제
   void deleteBoard(Long bno);

   //수정
   void modifyBoard(BoardReadDTO boardReadDTO);

   

}
