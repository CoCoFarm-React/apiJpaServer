package com.project.apiserver.productboard.service;

import java.util.List;

import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.productboard.dto.ProductDTO;
import com.project.apiserver.productboard.dto.ProductListDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
    
    PageResponseDTO<ProductListDTO> getList(PageRequestDTO requestDTO);

    ProductDTO readOne(Long pno);

    void register(ProductDTO productDTO);

    void delete(Long pno);

    void modify(ProductDTO productDTO);

}
