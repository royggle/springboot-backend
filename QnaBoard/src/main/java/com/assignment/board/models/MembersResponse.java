package com.assignment.board.models;

import java.util.List;

public class MembersResponse {
    public String result;
    public List<Member> members;

    public MembersResponse() {}

    public MembersResponse(String result) {
        this.result = result;
    }

    public MembersResponse(String result, List<Member> members) {
        this.result = result;
        this.members = members;
    }
}
