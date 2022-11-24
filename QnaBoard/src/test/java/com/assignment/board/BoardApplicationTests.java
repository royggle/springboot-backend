package com.assignment.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.board.models.Member;

import common.assignment.board.common.JwtAuth;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardApplicationTests {

//    @Test
//    void contextLoads() {
//        log.info("@Slf4j");
//    }
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private SqlSessionFactory sqlSessionFactory;
//
//    @Test
//    void membersRead() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Member> members = sqlSession.selectList("com.assignment.board.repositories.MembersRepository.read");
//        logger.info("Done: MembersRepository.read");
//    }
    
    @Test
    void tokenCreate() {
        Map<String, Object> member = new HashMap<>();
        member.put("name", "홍길동");
        member.put("age", 39);
        String token = JwtAuth.tokenCreate(member);
        System.out.println(token);
    }

    @Test
    void tokenCheck() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi7ZmN6ri464-ZIiwiYWdlIjozOX0.yZbJCNaviFRs-Y2cAqcqJ4xZoFVKaTJ-bKT_rt0186I";
        Member member = JwtAuth.tokenCheck(token);
        System.out.println(member);
    }
}
