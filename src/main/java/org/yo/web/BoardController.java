package org.yo.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.yo.service.BoardService;
import org.yo.vo.BbsVO;
import org.yo.web.util.BbsCriteria;
import org.yo.web.util.Criteria;

@Controller
@RequestMapping("/bbs/*")
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	//리스트 보여주기
	@RequestMapping("/board")
	public String board(@RequestParam(value="page", defaultValue = "1")Integer page, String category, String keyword, Model model){	//���������� model ��ü ����
		
		Criteria cri = new BbsCriteria();
		
		
		cri.setCurrentPage(page);
		if(keyword != null && keyword != ""){
			cri.setCategory(category);
			cri.setKeyword(keyword);
			String[] cate = category.split(":");
			
			
			for (String key : cate) {
				cri.addCri(key, keyword);
			}
		}
	
		logger.info(cri.toString());
		
		List<BbsVO> list = service.list(cri);

		
		cri.setCnt(list.get(0).getCnt());
		
		model.addAttribute("boardList", list);
		model.addAttribute("pageVo", cri);
		return "bbs/newList";
	}
	
	//글 보여주기
	@RequestMapping("/view")
	public String view(Integer bbsno, Model model){
		model.addAttribute("vo", service.read(bbsno));
		model.addAttribute("reList", service.replyList(bbsno));
		return "bbs/viewContent";
	}
	
	//글쓰기 화면전환
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(){
		return "bbs/write";
	}
	
	//글쓰기 동작
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(BbsVO vo, Model model){
		logger.info(vo.toString());
		logger.info("-------------------------");
		service.create(vo.setIsfile("F"));
		logger.info(vo.getBbsNo().toString());
		model.addAttribute("vo", service.read(vo.getBbsNo()));
		return "redirect:/bbs/board";
	}
	
	
	//글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String del(Integer bbsno, Model model){
		logger.info(bbsno.toString());
		service.delete(bbsno);
		return "redirect:/bbs/board";
	}
	
	//글 수정 화면 전환
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Integer bbsno, Model model){
		model.addAttribute("vo", service.read(bbsno));
		return "bbs/modifyContent";
	}
	
	//글수정 동작
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String update(BbsVO vo, Model model){
		logger.info(vo.toString());
		service.update(vo);
		
		model.addAttribute("vo", service.read(vo.getBbsNo()));
		return "bbs/view";
	}
	
}
