package com.project.apiserver.productboard.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.apiserver.productboard.dto.ProductDTO;
import com.project.apiserver.productboard.entity.Product;
import com.project.apiserver.productboard.repository.ProductRepository;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getList() {

        List<Product> result = repository.findAll();
        log.info("result------------------------ " + result);

        List<ProductDTO> dtoList = result.stream().map(e -> modelMapper.map(e, ProductDTO.class)).collect(Collectors.toList());
        log.info("dtoList------------------------ " + dtoList);
        
        return dtoList;

    }

    @Override
    public ProductDTO readOne(Long pno) {

        Product entity = repository.selectOne(pno);

        ProductDTO dto = modelMapper.map(entity, ProductDTO.class);
        log.info(dto);

        return dto;

    }
    
    

}
