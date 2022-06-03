package com.kh.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	

	@RequestMapping(value= "/map", method = RequestMethod.GET)
	public String map() {
		return "/board/map_test";
	}
	

}
