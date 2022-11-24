package com.assignment.board.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Member {
	private Integer member_idx;
	private String id;
	private String name;
	private String password;
	private String created_datetime;
	private String member_status;
	
    public Member() {}
    public Member(Integer member_idx, String id) {
    	this.member_idx = member_idx;
    	this.id = id;
    }

	public Integer getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(Integer member_idx) {
		this.member_idx = member_idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(String create_datetime) {
		this.created_datetime = create_datetime;
	}

	public String getMember_status() {
		return member_status;
	}

	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}

}

@JsonIgnoreProperties({"password"})
class MemberRead extends Member {
}
