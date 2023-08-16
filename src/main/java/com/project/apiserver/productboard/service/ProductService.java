package com.project.apiserver.productboard.service;



import java.util.List;

import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.productboard.dto.ProductDTO;
import com.project.apiserver.productboard.dto.ProductListByMemberDTO;
import com.project.apiserver.productboard.dto.ProductListDTO;
import com.project.apiserver.productboard.dto.ProductReadDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
    
    PageResponseDTO<ProductListDTO> getList(PageRequestDTO requestDTO);

    ProductReadDTO readOne(Long pno);

    void register(ProductDTO productDTO);

    void delete(Long pno);

    void modify(ProductDTO productDTO);

<<<<<<< HEAD
    PageResponseDTO<ProductListByMemberDTO> getListByMno(PageRequestDTO requestDTO, Long mno);
=======
>>>>>>> 9db7f46286aeb9f8df9b1d5e03b6fbff2e950bcd

}
