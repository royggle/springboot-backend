package com.assignment.board.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.assignment.board.models.Reply;

@Mapper
public interface RepliesRepository {
 	List<Reply> read(Integer board_idx);

    Integer create(Reply reply);

    Integer delete(Integer reply_idx);

    Integer update(@Param("reply_idx") Integer reply_idx, @Param("reply") Reply reply);
}
