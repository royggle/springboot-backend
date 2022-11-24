package com.assignment.board.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.board.models.Board;
import com.assignment.board.repositories.BoardsRepository;

@Service
public class BoardsService {
	@Autowired
    private BoardsRepository boardsRepository;
	
	public Integer readCount() {
		return boardsRepository.readCount();
	}
	
    public List<Board> read(Integer offset) {
        return boardsRepository.read(offset);
    }
    
    public Board detail(Integer board_idx) {
    	return boardsRepository.detail(board_idx);
    }

    public Integer create(Board board) {
        return boardsRepository.create(board);
    }

    public Integer delete(Integer board_idx) {
        return boardsRepository.delete(board_idx);
    }

    public Integer update(@Param("board_idx") Integer board_idx, @Param("board") Board board) {
        return boardsRepository.update(board_idx, board);
    }

	public Integer password(@Param("board_idx") Integer board_idx, @Param("password") String password) {
		return boardsRepository.password(board_idx, password);
	}
}
