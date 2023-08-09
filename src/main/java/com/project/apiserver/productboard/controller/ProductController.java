package com.project.apiserver.productboard.controller;

import java.util.List;
import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiserver.common.FileUploader;
import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.common.PageResponseDTO;
import com.project.apiserver.productboard.dto.ProductDTO;
import com.project.apiserver.productboard.dto.ProductListDTO;
import com.project.apiserver.productboard.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService productService;
    private final FileUploader fileUploader;

    // 목록
    // @ParameterObject 를 이용해 쿼리스트링으로 PageRequestDTO를 받음
    @GetMapping("/list")
    public PageResponseDTO<ProductListDTO> getList(@ParameterObject PageRequestDTO requestDTO){

        return productService.getList(requestDTO);

    }

    // 조회
    @GetMapping("/{pno}")
    public ProductDTO readOne(@PathVariable Long pno){

        // return productService.readOne(pno);
        return null;

    }

    // 등록
    @PostMapping("/")
    public Map<String, String> register(@RequestBody ProductDTO dto){

        // 이미지가 있을 때
        if(dto.getFiles() != null && dto.getFiles().size() > 0) {
            List<String> fileNames = fileUploader.uploadFiles(dto.getFiles(), true);
            dto.setImages(fileNames);
        }

        productService.register(dto);

        return Map.of("result", "success");

    }

    // 삭제
    @DeleteMapping("/{pno}")
    public Map<String, String> delete(@PathVariable Long pno){

        productService.delete(pno);

        return Map.of("result", "success");

    }

    // 수정
    @PutMapping("/")
    public Map<String, String> modify(@RequestBody ProductDTO dto){

        productService.modify(dto);

        return Map.of("result", "success");

    }

}
