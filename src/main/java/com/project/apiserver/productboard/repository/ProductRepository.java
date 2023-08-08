package com.project.apiserver.productboard.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.apiserver.productboard.entity.Product;
import com.project.apiserver.productboard.repository.search.ProductSearch;



public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearch {
    
    // 상세보기용을 위한 JPQL 작업
    @EntityGraph(attributePaths = "images")
    @Query("select p from Product p where p.delFlag = false and p.pno = :pno ")
    Product selectOne(@Param("pno")Long pno);

}