package com.kh.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.team.service.NonCommentService;
import com.kh.team.vo.NonCommentVo;

@RestController
@RequestMapping("/comment")
public class NonCommentContoller {
	
	@Autowired NonCommentService service;
	
	@RequestMapping(value="/insertComment", method=RequestMethod.POST)
	public String insertComment(NonCommentVo nonCommentVo) {
		System.out.println("insertComment, nonCommentVo:" + nonCommentVo);
		boolean result=service.nonCommentInsert(nonCommentVo);
		return String.valueOf(result);
	}
	
	@RequestMapping(value="/selectComment/{bno}", method=RequestMethod.GET)
	public List<NonCommentVo> selectComment(@PathVariable("bno") int bno) {
		System.out.println("selectComment, bno:" + bno);
		List<NonCommentVo> list =service.nonCommentSelect(bno);
		return list;
	}
	
	@RequestMapping(value="/updateComment",method=RequestMethod.POST)
	public String updateComment(NonCommentVo nonCommentVo) {
		boolean result = service.nonCommentUpdate(nonCommentVo);
		return String.valueOf(result);
	}
	
	@RequestMapping(value="deleteComment/{cno}",method=RequestMethod.GET)
	public String deleteComment(@PathVariable("cno") int cno) {
		boolean result =service.nonCommentDelete(cno);
		return String.valueOf(result);
	}
	
	
}
