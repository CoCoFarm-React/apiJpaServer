package com.project.apiserver.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.apiserver.subscription.entity.Subscription;

import jakarta.transaction.Transactional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tbl_subscription (from_account_mno, to_account_mno) VALUES (:frommno, :tomno)", nativeQuery = true)
    void insertSubscriptionNative(@Param("frommno") Long frommno, @Param("tomno") Long tomno);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_subscription WHERE from_account_mno = :frommno AND to_account_mno = :tomno", nativeQuery = true)
    void deleteSubscriptionNative(@Param("frommno") Long frommno, @Param("tomno") Long touser);
    

    @Query(value = "SELECT  COUNT(s) FROM Subscription s WHERE s.toAccount.mno = :mno GROUP BY s.toAccount.mno")
    Long countSub(@Param("mno") Long mno);
}
