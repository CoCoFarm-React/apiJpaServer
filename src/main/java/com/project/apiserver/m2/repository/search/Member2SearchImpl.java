package com.project.apiserver.m2.repository.search;

import com.project.apiserver.common.PageRequestDTO;
import com.project.apiserver.m2.entity.Member2;
import com.project.apiserver.m2.entity.QMember2;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


public class Member2SearchImpl extends QuerydslRepositorySupport implements Member2Search {

    public Member2SearchImpl() {
        super(Member2.class);
    }

    @Override
    public void search(PageRequestDTO requestDTO) {

        QMember2 member2 = QMember2.member2;

        JPQLQuery<Member2> query = from(member2);

        Pageable pageable = PageRequest.of(0,10, Sort.by("mno").descending());

        this.getQuerydsl().applyPagination(pageable, query);

        query.fetch();


    }
}
