package com.assignment.board.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.board.models.Board;
import com.assignment.board.models.BoardsResponse;
import com.assignment.board.models.Reply;
import com.assignment.board.services.BoardsService;
import com.assignment.board.services.RepliesService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/boards")
public class BoardsController {
	@Autowired
	private BoardsService boardsService;
	@Autowired
	private RepliesService repliesService;
	
    @RequestMapping(path = "", method = RequestMethod.POST)
    public BoardsResponse boardsCreate(@RequestBody Board board) {
        boardsService.create(board);
        return new BoardsResponse("created");
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public BoardsResponse boardsRead(
    		@RequestParam(required=false, defaultValue="1") int page
	) {
    	int pageSize = 5;
    	Integer count = boardsService.readCount();
        List<Board> boards = boardsService.read((page - 1) * pageSize);
        return new BoardsResponse("read", boards, count);
    }
    
    @RequestMapping(path = "/{board_idx}", method = RequestMethod.GET)
    public BoardsResponse boardsDetail(@PathVariable("board_idx") int board_idx) {
        Board board = boardsService.detail(board_idx);
        List<Reply> replies = repliesService.read(board_idx);
        return new BoardsResponse("detail", board, replies);
    }
    @RequestMapping(path = "/{board_idx}", method = RequestMethod.POST)
    public String boardsPassword(
    		@PathVariable("board_idx") int board_idx, 
    		@RequestBody String password
    ) {	
    	if(password == null) {
    		password = "";
    	}
    	else {
    	password = password.substring(0, password.length() - 1);
    	}
        Integer passwordCheck = boardsService.password(board_idx, password);
        System.out.println("password 들어오는 "+ password);
        System.out.println("결과값: "+ passwordCheck );
        if (passwordCheck == 0) {
        	return "Wrong Password";
        } else {
        	return "Correct Password"; 
        }
    }

    @RequestMapping(path = "/{board_idx}", method = RequestMethod.DELETE)
    public BoardsResponse boardsDelete(@PathVariable("board_idx") int board_idx) {
    	boardsService.delete(board_idx);
        return new BoardsResponse("deleted");
    }

    @RequestMapping(path = "/{board_idx}", method = {RequestMethod.PUT})
    public BoardsResponse boardsUpdate(
            @PathVariable("board_idx") int board_idx,
            @RequestBody Board board
    ) {
    	boardsService.update(board_idx, board);
        return new BoardsResponse("updated");
    }

	
}
