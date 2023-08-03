package com.project.apiserver.repository;// package com.project.apiserver.repository;

// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import com.project.apiserver.board.entity.Board;
// import com.project.apiserver.member.entity.Member;
// import com.project.apiserver.reply.dto.ReplyDTO;
// import com.project.apiserver.reply.entity.Reply;
// import com.project.apiserver.reply.repository.ReplyRepository;

// import lombok.extern.log4j.Log4j2;

// @SpringBootTest
// @Log4j2
// public class ReplyRepositoryTests {
    
//     @Autowired
//     private ReplyRepository replyRepository;

//     @Autowired
//     private ModelMapper modelMapper;
    

//     @Test
//     public void replyInsertTest(){

//         Board board = Board.builder().bno(100L).build();
//         Member member = Member.builder().email("aaa0@email.com").build();

//         for(int i=0; i<100; i++) {

//             Reply reply = Reply.builder()
//                 .reply("test reply" + i)
//                 .ord(true)
//                 .board(board)
//                 .member(member)
//                 .build();

//             replyRepository.save(reply);

//         }
//     }

//     @Test
//     public void replyListTest(){

//         Board board = Board.builder().bno(100L).build();

//         Pageable pageable = PageRequest.of(0, 20, Sort.by("rno").ascending());

//         //Page<ReplyDTO> result =  replyRepository.getReplyList(100L, pageable);

        
//     }

//     // 삭제
//     @Test
//     public void deleteReplyTest(){
        
//         ReplyDTO dto = ReplyDTO.builder().rno(3L).reply("삭제되었습니다.").delFlag(true).build();

//         Reply reply = modelMapper.map(dto, Reply.class);

//         replyRepository.save(reply);

//     }

//     // 수정
//     @Test
//     public void modifyReplyTest(){
        
//         ReplyDTO dto = ReplyDTO.builder()
//         .rno(8L)
//         .reply("수정하였습니다.")
//         .build();

//         Reply reply = modelMapper.map(dto, Reply.class);

//         replyRepository.save(reply);

//     }

// }
