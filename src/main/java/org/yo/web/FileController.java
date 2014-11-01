package org.yo.web;

import java.io.File;
import java.util.HashMap;
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

@Controller
@RequestMapping("/bbs/*")
public class FileController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileController.class);

	@Inject
	BoardService service;
	
	// 하나만 업로드할때.
	@RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
	public String singleUp(@RequestParam MultipartFile upfile, Model model,
			BbsVO vo) throws Exception {

		System.out.println("업로드 실행");
		boolean b = upfile.isEmpty();// false이면 업도드된 파일이 있다.

		String UUName = UUID.randomUUID().toString();

		// 업로드 한다.
		if (upfile != null && !b) {

			String fileName = upfile.getOriginalFilename();

			UUName += "_" + fileName;
			long fileSize = upfile.getSize();
			System.out.println("파일명 : " + UUName + ", 크기 : " + fileSize);
			
			// 파일 이동(임시저장소 upfile의 정보를 영구적 저장소 uploadDirectory로 보내준다)
			upfile.transferTo(new File("C:\\zzz\\upload", UUName));
			service.create(vo.setIsfile("T"));
			
			model.addAttribute("vo", service.read(vo.getBbsNo()));

		}

		return "/bbs/newList";

	}

}
