package com.assignment.board.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.board.models.Reply;
import com.assignment.board.repositories.RepliesRepository;

@Service
public class RepliesService {
	@Autowired
    private RepliesRepository repliesRepository;

    public List<Reply> read(Integer board_idx) {
        return repliesRepository.read(board_idx);
    }

    public Integer create(Reply reply) {
        return repliesRepository.create(reply);
    }

    public Integer delete(Integer reply_idx) {
        return repliesRepository.delete(reply_idx);
    }

    public Integer update(@Param("reply_idx") Integer reply_idx, @Param("reply") Reply reply) {
        return repliesRepository.update(reply_idx, reply);
    }
}
