package com.project.apiserver.repository;

import com.project.apiserver.member.entity.MemberAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.repository.BoardRepository;
import com.project.apiserver.common.Category;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;


import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void addBoard() {

        Category category = Category
        .builder()
        .cateno(1)
        .catename("관리자문의")
        .build();

        MemberAccount member = MemberAccount.builder().mno(1L).build();
        
        log.info("Start insert");

        for (int i = 0; i < 100; i++) {

            Board board = Board.builder()
                    .category(category)
                    .member(member)
                    .title("게시판 제목" + i)
                    .content("내용드릉ㄴ믕ㄴㅁ" + i)
                    .build();

            boardRepository.save(board);

        }

        log.info("------------------------------");
        log.info("End Insert");

    }
    @Test
    public void addNotice(){
        Category category = Category
        .builder()
        .cateno(5)
        .catename("공지사항")
        .build();
        MemberAccount member = MemberAccount.builder().email("aaa99@email.com").build();
        for(int i = 0; i<9; i++){
        Board board =Board.builder()
        .category(category)
        .member(member)
        .title("공지사항입니다~" +i)
        .content("차은우가 하고있어요" +i)
        .build();

        boardRepository.save(board);
        }
    }

    // @Test
    // @Transactional // lazy loading이라서 걸어줘야 함
    // public void readest() {


    //    IBoardListDTO result = boardRepository.getBoard(5L);
    //     log.info(result);

    //     log.info(result.getBno());
    //     log.info(result.getEmail());
    //     log.info(result.getCatename());
    //     log.info(result.getNickname());


    

    // @Test
    // public void readTest() {

    //     Optional<Board> result = boardRepository.findById(10L);

    //     Board board = result.orElseThrow();

    //     log.info(board);

    // }


    
    @Test
    public void searchTest(){

        PageRequestDTO pageRequestDTO = new PageRequestDTO(1, 10, "c", "1", 1);

        PageResponseDTO<BoardListDTO> responseDTO = boardRepository.search(pageRequestDTO);

        log.info(responseDTO);

    }

    
}
    // @Test
    // public void searchTest(){

    //     PageRequestDTO pageRequestDTO = new PageRequestDTO(1, 10, "c", "1", 1);

    //     PageResponseDTO<BoardListDTO> responseDTO = boardRepository.search(pageRequestDTO);

    //     log.info(responseDTO);

    // }



