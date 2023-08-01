package com.project.apiserver.reply.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.apiserver.reply.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("select r.rno, r.reply, m.nickname from Reply r left join Member m on m.email = r.member.email where r.board.bno = :bno")
    Page<Object[]> getReplyList(@Param("bno") Long bno, Pageable pageable);

    // 댓글 수 카운트
    @Query("select count(r) from Reply r where r.board.bno = :bno")
    long getCountReply(@Param("bno") Long bno);
    
}
