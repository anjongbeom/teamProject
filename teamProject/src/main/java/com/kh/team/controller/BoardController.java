package com.kh.team.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.service.BoardService;
import com.kh.team.util.MyFileUploader;
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
	
	
	@RequestMapping(value = "/createForm", method = RequestMethod.GET)
	public String create(BoardVo boardVo) {
		return "board/create_form";
		
	}
	
	@RequestMapping(value = "/createRun", method = RequestMethod.POST)
	public String createRun(BoardVo boardVo, RedirectAttributes rttr) {
		System.out.println("BoardController, createRun, boardVo: " + boardVo);
		boolean result = boardService.create(boardVo);
		System.out.println("BoardController, createRun, result: " + result);
		rttr.addFlashAttribute("create_result", result);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(int bno, Model model, PagingDto pagingDto) {
		System.out.println("BoardController, read, bno: " + bno);
		BoardVo boardVo = boardService.read(bno);
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("pagingDto", pagingDto);
		return "board/read";
	}
	
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm() {
		return "board/update_form";
	}
	
	@RequestMapping(value = "/updateRun" , method = RequestMethod.POST)
	public String updateRun(BoardVo boardVo, RedirectAttributes rttr,
			PagingDto pagingDto) {
		System.out.println("BoardController, updateRun, boardVo: " + boardVo);
		System.out.println("BoardController, updateRun, pagingDto: " + pagingDto);
		boolean result= boardService.update(boardVo);
		rttr.addFlashAttribute("update_result", result);
		rttr.addAttribute("bno", boardVo.getBno());
		rttr.addAttribute("page", pagingDto.getPage());
		rttr.addAttribute("perPage", pagingDto.getPerPage());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		return "redirect:/board/read";
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int bno, RedirectAttributes rttr
			, PagingDto pagingDto) {
		boolean result = boardService.delete(bno);
		rttr.addFlashAttribute("delete_result", result);
		rttr.addAttribute("page", pagingDto.getPage());
		rttr.addAttribute("perPage", pagingDto.getPerPage());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		System.out.println("BoardController, delete, bno: " + bno);
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, PagingDto pagingDto){
		pagingDto.setCount(boardService.getCount(pagingDto));
		pagingDto.setPage(pagingDto.getPage());
		List<BoardVo> boardList = boardService.list(pagingDto);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingDto", pagingDto);
		return "board/list";
		
	}
	
	@RequestMapping(value = "/replyForm", method = RequestMethod.GET)
	public String replyForm(int bno, Model model) {
		BoardVo boardVo = boardService.read(bno);
		model.addAttribute("boardVo",boardVo);
		return "board/reply_form";
	}
	
	@RequestMapping(value = "/replyRun", method = RequestMethod.POST)
	public String replyRun(BoardVo boardVo, RedirectAttributes rttr) {
		boolean result = boardService.insertReply(boardVo);
		rttr.addFlashAttribute("replyRun", result);
		return"redirect:/board/list";
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(MultipartFile file) throws Exception {
		System.out.println("file : " + file);
		String originalFilename = file.getOriginalFilename();
		byte[] fileData = file.getBytes();
		String saveFilename = MyFileUploader.uploadFile(
				"C:/boardattach2", originalFilename, fileData);
		System.out.println("saveFilename" + saveFilename);
		return saveFilename;
		
	}
	
	@RequestMapping(value = "/deleteFile", method = RequestMethod.GET)
	@ResponseBody
	public String deleteFile(String filename) {
		boolean result = MyFileUploader.deleteFile(filename);
		return String.valueOf(result);
	}

}
