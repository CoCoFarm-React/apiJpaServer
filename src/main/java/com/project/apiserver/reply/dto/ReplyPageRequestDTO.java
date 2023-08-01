package com.project.apiserver.reply.dto;

import com.project.apiserver.common.PageRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyPageRequestDTO extends PageRequestDTO {
    
    private Long bno;
    
    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 20;

    private boolean last;

}
