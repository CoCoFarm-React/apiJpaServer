package com.project.apiserver.productboard.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.apiserver.common.Category;
import com.project.apiserver.common.FileUploader;
import com.project.apiserver.common.ProductCategory;
import com.project.apiserver.member.dto.MemberAccountDTO;
import com.project.apiserver.member.entity.MemberAccount;
import com.project.apiserver.productboard.dto.ProductDTO;
import com.project.apiserver.productboard.entity.Product;
import com.project.apiserver.productboard.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository repository;
    private final ModelMapper modelMapper;
    private final FileUploader fileUploader;

    // 목록
    @Override
    public List<ProductDTO> getList() {

        List<Product> result = repository.findAll();
        log.info("result------------------------ " + result);

        List<ProductDTO> dtoList = result.stream().map(e -> modelMapper.map(e, ProductDTO.class)).collect(Collectors.toList());
        log.info("dtoList------------------------ " + dtoList);
        
        return dtoList;

    }

    // 조회
    @Override
    public ProductDTO readOne(Long pno) {

        Product entity = repository.selectOne(pno);

        ProductDTO dto = modelMapper.map(entity, ProductDTO.class);
        log.info(dto);

        return dto;

    }

    // 등록
    @Override
    public void register(ProductDTO dto) {

        MemberAccount member = MemberAccount.builder().mno(dto.getMno()).build();
        ProductCategory category = ProductCategory.builder().procateno(dto.getProcateno()).build();

        Product product = Product.builder()
            .pname(dto.getPname())
            .pdesc(dto.getPdesc())
            .price(dto.getPrice())
            .member(member)
            .category(category).build();

        dto.getImages().forEach(img -> {
            log.info(img);
            product.addImage(img);
        });

        repository.save(product);

    }

    // 삭제
    @Override
    public void delete(Long pno) {

        Optional<Product> result = repository.findById(pno);
        Product product = result.orElseThrow();

        product.changeDel(true);
        product.changePname("삭제된 게시물입니다.");
        product.changePdesc("삭제된 게시물입니다.");
        product.changePrice(0);
        product.clearImages();
        
        repository.save(product);

        List<String> fileNames = product.getImages().stream().map(pi -> pi.getFname()).collect(Collectors.toList());
        fileUploader.removeFiles(fileNames);

    }

    @Override
    public void modify(ProductDTO productDTO) {
        
        Optional<Product> result = repository.findById(productDTO.getPno());
        Product product = result.orElseThrow();

        product.changePdesc(productDTO.getPdesc());
        product.changePname(productDTO.getPname());
        product.changePrice(productDTO.getPrice());
        product.changeProductCategory(ProductCategory.builder().procateno(productDTO.getProcateno()).build());
        
        // // 엔티티에 담긴 기존 이미지 이름 목록
        List<String> oldFileNames = product.getImages().stream().map(pi -> pi.getFname()).collect(Collectors.toList());

        product.clearImages();

        // dto의 파일 이름을 엔티티에 담고 저장
        productDTO.getImages().forEach(fname -> product.addImage(fname));
        repository.save(product);

        // 세이브 성공했으면 기존 파일들 중 productDTO.getImages()에 없는 파일 찾기
        List<String> newFiles = productDTO.getImages();
        List<String> wantDeleteFiles = oldFileNames.stream().filter(f -> newFiles.indexOf(f) == -1).collect(Collectors.toList());

        fileUploader.removeFiles(wantDeleteFiles);

    }
    

}
