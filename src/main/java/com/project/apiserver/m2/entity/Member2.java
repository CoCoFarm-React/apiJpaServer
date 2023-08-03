package com.project.apiserver.m2.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_member2")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    private String email;

    private String pw;
    private String nickname;


    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private List<Member2Role> role = new ArrayList<>();

    public void addRole (Member2Role data){
        role.add(data);

    }

}
