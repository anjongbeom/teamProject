package com.kh.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.vo.BoardVo;

import service.BoardService;



@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value= "/menu1", method = RequestMethod.GET)
	public String menu1() {
		return "/product/menu1";
	}
	

	@RequestMapping(value= "/map", method = RequestMethod.GET)
	public String map() {
		return "/board/map_test";
	}
	
	
	// ±Û µî·Ï
	@RequestMapping(value = "/createRun", method = RequestMethod.POST)
	public String create(BoardVo boardVo, RedirectAttributes rttr) {
		System.out.println("BoardController, createRun, boardVo: " + boardVo);
		boolean result = boardService.create(boardVo);
		System.out.println("BoardController, createRun, result: "+ result);
		rttr.addFlashAttribute("create_result", result);
		return "redirect:/board/list";
	}
		
	
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String list() {
		return "/board/list";
	}
	

}
