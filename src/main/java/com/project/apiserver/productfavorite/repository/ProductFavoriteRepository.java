package com.project.apiserver.productfavorite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.apiserver.productfavorite.entity.ProductFavorite;

import jakarta.transaction.Transactional;

public interface ProductFavoriteRepository extends JpaRepository<ProductFavorite, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tbl_product_favorite (member_mno, product_pno) VALUES (:mno, :pno)", nativeQuery = true)
    void insertFavorite(@Param("pno") Long pno, @Param("mno") Long mno);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_product_favorite WHERE pno = :pno AND mno = :mno", nativeQuery = true)
    void deleteFavorite(@Param("pno") Long pno, @Param("mno") Long mno);
    

    @Query(value = "SELECT  COUNT(p) FROM ProductFavorite p WHERE p.product.pno = :pno GROUP BY p.product.pno")
    Long countFavorite(@Param("pno") Long pno);
    
}
