package com.project.apiserver.repository;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.common.ProductCategory;
import com.project.apiserver.member.entity.MemberAccount;
import com.project.apiserver.productboard.entity.Product;
import com.project.apiserver.productboard.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    // 등록
    @Test
    public void insertTest(){

        MemberAccount account = MemberAccount.builder().mno(3L).build();
        ProductCategory category = ProductCategory.builder().procateno(1).build();

        for(int i= 0; i<5; i ++){
            Product product = Product.builder()
                            .pname("productTest" +i)
                            .pdesc("descTest" +i)
                            .member(account)
                            .price(35000)
                            .category(category)
                            .build();
            
            product.addImage(UUID.randomUUID().toString()+ "_aaa.jpg");
            product.addImage(UUID.randomUUID().toString()+"_bbb.jpg");
            product.addImage(UUID.randomUUID().toString()+"_ccc.jpg");

            repository.save(product);
        }
    }

    // 목록
    @Test
    @Transactional
    public void getListTest(){

        List<Product> list = repository.findAll();

        list.forEach(data ->
        log.info(data + data.getCategory().getProcatename()));

    }

    // 조회
    @Test
    @Transactional
    public void readTest(){
        
        log.info(repository.selectOne(2L));

    }

}
