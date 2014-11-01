package org.yo.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yo.service.BoardService;
import org.yo.vo.ReplyVO;


@Controller
@RequestMapping("/bbs/reply/*")
public class ReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private BoardService service;
	
	//리플달기 처리
	@RequestMapping("/write")
	public String insert(ReplyVO vo, Model model){
		service.replyCre(vo);
		//model.addAttribute("reList", service.replyList(bbsno));
		return "redirect:/bbs/board";
	}
	
	//리플수정 처리
	@RequestMapping("/modify")
	public String update(ReplyVO vo){
		service.replyUpdate(vo);
		return "redirect:/bbs/board";
	}
	
	//리플삭제 처리
	@RequestMapping("/delete")
	public String delete(Integer replyNo){
		service.replyDelete(replyNo);
		return "redirect:/bbs/board";
		
	}
	

	
}
