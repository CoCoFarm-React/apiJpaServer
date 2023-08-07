package com.project.apiserver.productboard.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.apiserver.productboard.entity.ProductImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    
    private Long pno;
    private String pname;
    private String pdesc;
    private int price;
    private boolean delFlag;

    private Long mno;
    private Integer procateno;

    private List<ProductImage> images;

}
