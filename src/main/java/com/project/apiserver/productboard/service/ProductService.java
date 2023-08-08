package com.project.apiserver.productboard.service;

import java.util.List;
import com.project.apiserver.productboard.dto.ProductDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
    
    List<ProductDTO> getList();

    ProductDTO readOne(Long pno);

    void register(ProductDTO productDTO);

    void delete(Long pno);

    void modify(ProductDTO productDTO);

}
