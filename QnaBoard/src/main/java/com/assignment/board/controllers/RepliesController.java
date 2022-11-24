package com.assignment.board.controllers;

import java.util.List;

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
import com.assignment.board.models.RepliesResponse;
import com.assignment.board.models.Reply;
import com.assignment.board.services.RepliesService;

import common.assignment.board.common.JwtAuth;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/replies")
public class RepliesController {
	@Autowired
	private RepliesService repliesService;
	
    @RequestMapping(path = "", method = RequestMethod.POST)
    public RepliesResponse repliesCreate(
    		@RequestBody Reply reply,
    		@RequestHeader("x-jwt-token") String token
    ) {
    	Member member = JwtAuth.tokenCheck(token);
    	reply.setId(member.getId());
        repliesService.create(reply);
        return new RepliesResponse("created");
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public RepliesResponse repliesRead(
    		@RequestParam("board_idx") Integer board_idx
	) {
        List<Reply> replies = repliesService.read(board_idx);
        return new RepliesResponse("read", replies);
    }

    @RequestMapping(path = "/{reply_idx}", method = RequestMethod.DELETE)
    public RepliesResponse repliesDelete(@PathVariable("reply_idx") int reply_idx) {
    	repliesService.delete(reply_idx);
        return new RepliesResponse("deleted");
    }

    @RequestMapping(path = "/{reply_idx}", method = {RequestMethod.PUT})
    public RepliesResponse repliesUpdate(
            @PathVariable("reply_idx") int reply_idx,
            @RequestBody Reply reply
    ) {
    	repliesService.update(reply_idx, reply);
        return new RepliesResponse("updated");
    }
}
