package com.project.apiserver.productboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.productboard.dto.ProductDTO;
import com.project.apiserver.productboard.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService productService;

    @GetMapping("/list")
    public List<ProductDTO> getList(){

        return productService.getList();

    }

    @GetMapping("/{pno}")
    public ProductDTO readOne(@PathVariable Long pno){

        return productService.readOne(pno);

    }

}
