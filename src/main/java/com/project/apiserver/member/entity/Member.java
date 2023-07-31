package com.project.apiserver.member.entity;

import java.util.ArrayList;
import java.util.List;

import com.project.apiserver.common.BaseEntity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"role"})
public class Member extends BaseEntity {
    
    @Id
    private String email;

    private String pw;
    private String nickname;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private List<MemberRole> role = new ArrayList<>();

    // Role 추가하는 메소드

    public void addRole (MemberRole data){

        MemberRole addrole =data;

        role.add(addrole);
        
    }
    
}


