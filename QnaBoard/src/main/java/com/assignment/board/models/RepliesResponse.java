package com.assignment.board.models;

import java.util.List;

public class RepliesResponse {
    public String result;
    public List<Reply> replies;
        
    public RepliesResponse() {}

    public RepliesResponse(String result) {
		this.result = result;
	}

	public RepliesResponse(String result, List<Reply> replies) {
		this.result = result;
		this.replies = replies;
	}
}
