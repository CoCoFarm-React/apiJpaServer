package com.project.apiserver.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.project.apiserver.board.dto.BoardListDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.repository.BoardRepository;
import com.project.apiserver.common.Category;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.member.entity.Member;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    // @Test
    // public void addBoard() {

    //     Category category = Category.builder().cateno(1).catename("관리자문의").build();
    //     Member member = Member.builder().email("aaa0@email.com").build();
    //     log.info("Start insert");

    //     for (int i = 0; i < 100; i++) {

    //         Board board = Board.builder()
    //                 .category(category)
    //                 .member(member)
    //                 .title("게시판 제목" + i)
    //                 .content("내용드릉ㄴ믕ㄴㅁ" + i)
    //                 .build();

    //         boardRepository.save(board);

    //     }

    //     log.info("------------------------------");
    //     log.info("End Insert");

    // }

    @Test
    @Transactional // lazy loading이라서 걸어줘야 함
    public void readest() {


        Object[] result = boardRepository.getBoard(5L);
        log.info(result);

    }

    // @Test
    // public void readTest() {

    //     Optional<Board> result = boardRepository.findById(10L);

    //     Board board = result.orElseThrow();

    //     log.info(board);

    // }

    @Test
    public void searchTest(){

        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResponseDTO<BoardListDTO> responseDTO = boardRepository.search(pageRequestDTO);

        log.info(responseDTO);

    }

}
