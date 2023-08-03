package com.project.apiserver.member.repository.search;



import com.project.apiserver.member.entity.MemberAccount;

import com.project.apiserver.member.entity.QMemberAccount;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

public class MemberSearchImpl extends QuerydslRepositorySupport implements  MemberSearch {


    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public MemberSearchImpl() {
        super(MemberAccount.class);
    }

    @Override
    public void searchMember() {

        QMemberAccount member = QMemberAccount.memberAccount;

        JPQLQuery<MemberAccount> query = from(member);

        Pageable pageable = PageRequest.of(0,10, Sort.by("mno").descending());

        this.getQuerydsl().applyPagination(pageable,query);

        //query.orderBy(new OrderSpecifier(Order.DESC, member.mno));

        query.fetch();

    }
}
