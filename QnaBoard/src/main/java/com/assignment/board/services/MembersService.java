package com.assignment.board.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.board.models.Member;
import com.assignment.board.repositories.MembersRepository;

@Service
public class MembersService {
    @Autowired
    private MembersRepository membersRepository;

    public List<Member> read() {
        return membersRepository.read();
    }
    
    public Member login(Member member) {
        return membersRepository.login(member);
    }
    
    public Integer create(Member member) {
        return membersRepository.create(member);
    }

    public Integer delete(Integer id) {
        return membersRepository.delete(id);
    }

    public Integer update(@Param("id") Integer id, @Param("member") Member member) {
        return membersRepository.update(id, member);
    }
}
