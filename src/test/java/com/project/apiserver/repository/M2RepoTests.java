package com.project.apiserver.repository;

import com.project.apiserver.m2.repository.Member2Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class M2RepoTests
{
    @Autowired
    private Member2Repository repository;

    @Test
    public void test1() {

        repository.search(null);

    }
}
