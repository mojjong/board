package org.yo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yo.service.BoardService;
import org.yo.vo.BbsVO;
import org.yo.web.util.BbsCriteria;
import org.yo.web.util.Criteria;

@Controller
@RequestMapping("/bbs/*")
public class BoardController {

	private static Logger logger = LoggerFactory
			.getLogger(BoardController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "bbs/newList";
	}
	
	// 리스트 보여주기
	@RequestMapping(value = "/list", produces="application/json")
	@ResponseBody
	public List<BbsVO> board(@RequestParam(value = "page", defaultValue = "1") Integer page,
			String category, String keyword) {
		
		Criteria cri = new BbsCriteria();

		cri.setCurrentPage(page);
		if (keyword != null && keyword != "") {
			cri.setCategory(category);
			cri.setKeyword(keyword);
			String[] cate = category.split(":");

			for (String key : cate) {
				cri.addCri(key, keyword);
			}
		}

		logger.info(cri.toString());

		return service.list(cri);
		
		
/*
		Criteria cri = new BbsCriteria();

		cri.setCurrentPage(page);
		if (keyword != null && keyword != "") {
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
		return "bbs/newList";*/
	}

	// 글 보여주기
	@RequestMapping("/view")
	public String view(Integer bbsno, Model model) {
		
		BbsVO vo = service.read(bbsno);
		
		logger.info(vo.getSuffixs().toString());
		
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("reList", service.replyList(bbsno));
		return "bbs/viewContent";
	}

	// 글쓰기 화면전환
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "bbs/write";
	}

	// 글쓰기 동작
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(BbsVO vo, Model model) throws Exception{
		// 파일 업로드 동작이 추가될 경우.
		
		logger.info("BoardController - write : " + vo.toString());
		
		//vo에 자동으로 업로드파일들이 set된다.
		List<String> fileNames = vo.getFileNames();
		
		List<String> suffixs = new ArrayList<String>();
		
		if(fileNames.size() != 0){
			for(String fileName : fileNames){
				logger.info(fileName);
				String s = fileName.substring(fileName.lastIndexOf("."));
				logger.info(s);
				vo.setIsfile("T");
				suffixs.add(s);
			}
		}
		vo.setSuffixs(suffixs);
		
		logger.info(vo.toString());
		
		service.create(vo);
		
		return "redirect:/bbs/board";
	}

	// 글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String del(Integer bbsno, Model model) {
		logger.info(bbsno.toString());
		service.delete(bbsno);
		return "redirect:/bbs/board";
	}

	// 글 수정 화면 전환
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Integer bbsno, Model model) {
		model.addAttribute("vo", service.read(bbsno));
		return "bbs/modifyContent";
	}

	// 글수정 동작
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String update(BbsVO vo, Model model) {
		logger.info(vo.toString());
		service.update(vo);

		model.addAttribute("vo", service.read(vo.getBbsNo()));
		return "bbs/view";
	}

}
