package com.assignment.board.models;

public class Reply {
	private Integer reply_idx;
	private Integer board_idx;
    private String contents;
    private String created_datetime;
   	private String id;
   	
	public Integer getReply_idx() {
		return reply_idx;
	}
	public void setReply_idx(Integer reply_idx) {
		this.reply_idx = reply_idx;
	}
	public Integer getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(Integer board_idx) {
		this.board_idx = board_idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
   	
}
