package com.project.apiserver.reply.entity;

import com.project.apiserver.board.entity.Board;
import com.project.apiserver.common.BaseEntity;


import com.project.apiserver.member.entity.MemberAccount;
import groovy.transform.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@ToString(excludes = {"member", "board"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "tbl_reply")
public class Reply extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    private String reply;
    private boolean ord;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberAccount member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    private boolean delFlag;

    public void changeDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }

    public void changeReply(String reply) {
        this.reply = reply;
    }
    public void changeOrd (boolean ord){
        this.ord = ord;
    }

}
