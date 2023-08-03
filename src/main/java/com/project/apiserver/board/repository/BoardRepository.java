package com.project.apiserver.board.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.apiserver.board.dto.BoardReadDTO;
import com.project.apiserver.board.entity.Board;
import com.project.apiserver.board.repository.search.BoardSearch;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

    //Long bno, String title, String email, String nickname, String catename, Long rcnt,
    //Integer cateno, LocalDateTime regDate

    // @Query("SELECT new com.project.apiserver.board.dto.BoardListDTO (b.bno, b.title, b.member.email email , b.member.nickname nickname, b.category.catename catename, 0L , b.category.cateno cateno, b.regDate ) " + 
    //         "FROM Board b LEFT JOIN Member m on m = b.member LEFT JOIN Category c on c = b.category " + 
    //         "WHERE b.bno = :bno " )
    // // @Query("SELECT b.bno bno, b.title, b.member.email email , b.member.nickname nickname, b.category.catename catename, 0L , b.category.cateno cateno, b.regDate " + 
    //         "FROM Board b LEFT JOIN Member m on m = b.member LEFT JOIN Category c on c = b.category " + 
    //         "WHERE b.bno = :bno " )            
    // IBoardListDTO getBoard(@Param("bno") Long bno);

    @Query("select new com.project.apiserver.board.dto.BoardReadDTO(b.bno, b.title, b.content, m.email, m.nickname, c.catename, b.category.cateno, b.regDate, b.modDate, b.delFlag) from Board b left join b.member m left join b.category c where b.bno = :bno")
    BoardReadDTO getBoardInfo(@Param("bno") Long bno);
    

}
