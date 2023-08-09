package com.project.apiserver.productboard.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.project.apiserver.productboard.entity.Product;
import com.project.apiserver.productboard.repository.search.ProductSearch;



public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearch {
    
    // 상세보기용을 위한 JPQL 작업
    // @EntityGraph(attributePaths = "images")
    // @Query("select p from Product p where p.delFlag = false and p.pno = :pno ")
    // Product selectOne(@Param("pno")Long pno);

    @EntityGraph(attributePaths = "images")
    @Query("select p.pno, p.del_flag, p.pdesc, p.pname, p.price, p.mod_date, m.mno, m.del_flag, m.email, m.nickname, m.role_name, c.procateno, c.procatename, count(pi.product_pno) as imageCount " +
    "from Product p join MemberAccount m join ProductCategory c join ProductImage pi " +
    "on p.member_mno = m.mno and p.category_procateno = c.procateno " + 
    "where p.del_flag = false and p.pno = :pno " + 
    "GROUP BY " + 
    "    p.pno, p.del_flag, p.pdesc, p.pname, p.price, p.mod_date, " + 
    "    m.mno, m.del_flag, m.email, m.nickname, m.role_name, " + 
    "    c.procateno, c.procatename " + 
    "order by p.pno desc")
    Product selectOne(@Param("pno")Long pno);

}