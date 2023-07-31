package com.project.apiserver.member.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {

    private String email;
    private String pw;
    private String nickname;
    private String role;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regDate;
}
