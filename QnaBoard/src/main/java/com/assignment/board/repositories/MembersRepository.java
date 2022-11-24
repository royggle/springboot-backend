package com.assignment.board.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.assignment.board.models.Member;

@Mapper
public interface MembersRepository {
    List<Member> read();
    
    Member login(Member memeber);

    Integer create(Member Member);

    Integer delete(Integer member_idx);

    Integer update(@Param("member_idx") Integer member_idx, @Param("member") Member member);
}
