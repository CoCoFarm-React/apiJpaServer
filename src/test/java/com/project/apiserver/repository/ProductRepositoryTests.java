package com.project.apiserver.repository;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.member.entity.MemberAccount;
import com.project.apiserver.productboard.entity.Product;
import com.project.apiserver.productboard.repository.ProductRepository;

@SpringBootTest
public class ProductRepositoryTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void insertTest(){

        MemberAccount account = MemberAccount.builder().mno(3L).build();

        for(int i= 0; i<5; i ++){
            Product product = Product.builder()
                            .pname("productTest" +i)
                            .pdesc("descTest" +i)
                            .member(account)
                            .price(35000)
                            .build();
            
        product.addImage(UUID.randomUUID().toString()+ "_aaa.jpg");
        product.addImage(UUID.randomUUID().toString()+"_bbb.jpg");
        product.addImage(UUID.randomUUID().toString()+"_ccc.jpg");

        productRepository.save(product);
        }
    }

}
