package com.assignment.board.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.board.models.Member;
import com.assignment.board.models.MembersResponse;
import com.assignment.board.services.MembersService;

import common.assignment.board.common.JwtAuth;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/members")
public class MembersController {
    @Autowired
    private MembersService membersService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public MembersResponse membersCreate(@RequestBody Member member) {
        membersService.create(member);
        return new MembersResponse("created");
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public MembersResponse membersRead(
    		@RequestHeader("x-jwt-token") String token
	) {
    	System.out.println(token);
    	Member member = JwtAuth.tokenCheck(token);
    	System.out.println(member);
        List<Member> members = membersService.read();
        return new MembersResponse("read", members);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public MembersResponse membersDelete(@PathVariable("id") int id) {
        membersService.delete(id);
        return new MembersResponse("deleted");
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.PUT})
    public MembersResponse membersUpdate(
            @PathVariable("id") int id,
            @RequestBody Member member
    ) {
        membersService.update(id, member);
        return new MembersResponse("updated");
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String membersLogin(@RequestBody Member member) {
    	Member memberLogin = membersService.login(member);
    	if (memberLogin == null) {
    		return "No User";
    	} else {
            Map<String, Object> mapMember = new HashMap<>();
            mapMember.put("id", memberLogin.getId());
            mapMember.put("member_idx", memberLogin.getMember_idx());
            return JwtAuth.tokenCreate(mapMember);    		
    	}
    }

    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public Member membersCheck(@RequestParam String token) {
    	Member member = JwtAuth.tokenCheck(token);
        return member;
    }
}
