package org.yo.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.yo.service.BoardService;
import org.yo.vo.BbsVO;

@Controller
@RequestMapping("/bbs/file/*")
public class FileController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileController.class);

	@Inject
	BoardService service;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void singleDown(BbsVO vo, Model model, HttpServletResponse response) throws IOException {

		System.out.println(vo.toString());
		
		// 선택한 글번호로 그 글에 업로드된 파일의 이름 가져오기
		String UUFileName = service.getFileName(vo);
		
		System.out.println("다운 : " + UUFileName);
		
		File downFile = new File("C:\\zzz\\upload\\" + UUFileName);
		
		// 응답처리
		// 1. contentType처리
		response.setContentType("application/octet-stream");
		
		// 2. 다운 로드할 파일 명을 header정보로 설정
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String(vo.getFilename().getBytes("UTF-8"), "8859_1"));// 8859-1방식은 라틴방식이다. (한글처리)
		
		// 위에서 filename으로 파일이 넘어간다.
		OutputStream os = response.getOutputStream();
		FileInputStream fi = new FileInputStream(downFile);
		
		// fi.read()한것을 os.write한 효과가 난다. 클라이언트에게 파일이 날아간다.
		FileCopyUtils.copy(fi, os);
		
	}

}
