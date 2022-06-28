package com.kh.team.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.kh.team.service.BoardService;
import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;



@Controller
@RequestMapping("/board")
public class BoardController {
	
//	@Resource(name="boardService")
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value= "/menu1", method = RequestMethod.GET)
	public String menu1() {
		return "/product/menu1";
	}
	
	@RequestMapping(value= "/review", method = RequestMethod.GET)
	public String review() {
		return "/board/review";
	}
	

	@RequestMapping(value= "/map", method = RequestMethod.GET)
	public String map() {
		return "/board/map_test";
	}
	
	@RequestMapping(value= "/contact", method = RequestMethod.GET)
	public String contact() {
		return "/board/contact";
	}
	
	
	
	@RequestMapping(value = "/createRun", method = RequestMethod.POST)
	public String create(BoardVo boardVo, RedirectAttributes rttr) {
		System.out.println("BoardController, createRun, boardVo: " + boardVo);
		boolean result = boardService.create(boardVo);
		System.out.println("BoardController, createRun, result: "+ result);
		rttr.addFlashAttribute("create_result", result);
		return "redirect:/board/list";
	}
		
	
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String list(Model model, PagingDto pagingDto) {
		List<BoardVo> boardList = boardService.list(pagingDto);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingDto", pagingDto);
		return "/board/list";
	}

}
