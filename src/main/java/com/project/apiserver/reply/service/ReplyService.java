package com.project.apiserver.reply.service;

import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.reply.dto.ReplyDTO;
import com.project.apiserver.reply.dto.ReplyPageRequestDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ReplyService {

    PageResponseDTO<ReplyDTO> getReplyList(ReplyPageRequestDTO requestDTO);

    void registReply(ReplyDTO replyDTO);

    void deleteReply(Long rno);

    void modifyReply(ReplyDTO replyDTO);

    ReplyDTO readOneReply(Long rno);

}
