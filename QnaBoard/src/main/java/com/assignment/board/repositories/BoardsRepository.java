package com.assignment.board.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.assignment.board.models.Board;

@Mapper
public interface BoardsRepository {
	 	List<Board> read(Integer offset);
	 	
	 	Integer readCount();
	 	
	 	Board detail(Integer board_idx);
	 	
	 	Integer password(@Param("board_idx") Integer board_idx, @Param("password") String password);

	    Integer create(Board board);

	    Integer delete(Integer board_idx);

	    Integer update(@Param("board_idx") Integer board_idx, @Param("board") Board board);
	}

