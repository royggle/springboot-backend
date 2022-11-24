package com.assignment.board.models;

import java.util.List;

public class BoardsResponse {
	    public String result;
	    public List<Board> boards;
	    public Integer count;
	    public Board board;
	    public List<Reply> replies;
	        
	    public BoardsResponse() {}

	    public BoardsResponse(String result) {
			this.result = result;
		}

		public BoardsResponse(String result, List<Board> boards, Integer count) {
			this.result = result;
			this.boards = boards;
			this.count = count;
		}
		
		public BoardsResponse(String result, Board board, List<Reply> replies) {
			this.result = result;
			this.board = board;
			this.replies = replies;
			
		}
}