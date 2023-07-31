package com.project.apiserver.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.board.service.BoardService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void getList(){


        log.info(boardService.getBoardList());

    }
    
}
