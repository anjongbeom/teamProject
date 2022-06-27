package com.kh.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.service.Non_memberBoardService;
import com.kh.team.vo.NonMemberBoardVo;

@Controller
@RequestMapping("/nonBoard")
public class NonBoardController {

	@Autowired
	private Non_memberBoardService service;
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() {
			return "nonboard/writeForm";
		}
	
	@RequestMapping(value="/insertWrite",method=RequestMethod.POST)
	public String insertWrite(NonMemberBoardVo nonmemberBoardVo,RedirectAttributes rttr) {
		System.out.println("BoardController, insertWrite, nonmemberBoardVo:" + nonmemberBoardVo);
		boolean result =service.nonInsertBoardMember(nonmemberBoardVo);
		rttr.addAttribute("result",result);
		return "redirect:/nonBoard/list";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getBoardList(Model model) {
		List<NonMemberBoardVo> list=service.nonSelectListBoardMember();
		model.addAttribute("list",list);
		return "nonboard/list";
	}
	
	@RequestMapping(value="/modifyForm",method=RequestMethod.GET)
	public String modifyForm(int bno,Model model) {
		
		NonMemberBoardVo list = service.nonSelectBoardMember(bno);
		model.addAttribute("list",list);
		return "nonboard/read";
	}
	
	@RequestMapping(value="/modifyRun",method=RequestMethod.POST)
	public String modifyRun(NonMemberBoardVo nonMemberBoardVo,RedirectAttributes rttr) {
		
		boolean result = service.nonUpdateBoardMember(nonMemberBoardVo);
		System.out.println(nonMemberBoardVo);
		rttr.addAttribute("result",result);
		return "redirect:/nonBoard/list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(int bno,RedirectAttributes rttr) {
		boolean result = service.nonDeleteBoardMember(bno);
		rttr.addAttribute("result",result);
		return "redirect:/nonBoard/list";
	}
	
	@RequestMapping(value="/replyForm",method=RequestMethod.GET)
	public String replyForm(int bno,Model model) {
		NonMemberBoardVo list =service.replyForm(bno);
		model.addAttribute("nonMemVo",list);
		return "nonboard/replyForm";
	}
	
	@RequestMapping(value="/replyRun",method=RequestMethod.POST)
	public String replyRun(NonMemberBoardVo nonMemberBoardVo,RedirectAttributes rttr) {
		boolean result =service.replyRun(nonMemberBoardVo);
		rttr.addAttribute("reply_result",result);
		return "redirect:/nonBoard/list";
	}
	
}
