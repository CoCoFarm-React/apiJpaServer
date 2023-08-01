package com.project.apiserver.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.project.apiserver.board.entity.Board;
import com.project.apiserver.member.entity.Member;
import com.project.apiserver.reply.entity.Reply;
import com.project.apiserver.reply.repository.ReplyRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void replyInsertTest(){

        Board board = Board.builder().bno(100L).build();
        Member member = Member.builder().email("aaa0@email.com").build();

        for(int i=0; i<100; i++) {

            Reply reply = Reply.builder()
                .reply("test reply" + i)
                .ord(0)
                .board(board)
                .member(member)
                .build();

            replyRepository.save(reply);

        }
    }

    @Test
    public void replyListTest(){

        Board board = Board.builder().bno(100L).build();

        Pageable pageable = PageRequest.of(0, 20, Sort.by("rno").ascending());

        log.info(replyRepository.getReplyList(board.getBno(), pageable));

    }


}
