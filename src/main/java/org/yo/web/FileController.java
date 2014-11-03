package org.yo.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("/bbs/file/*")
public class FileController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileController.class);

	@Inject
	BoardService service;

	// 하나만 업로드할때.
	@RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
	public String singleUp(@RequestParam MultipartFile upfile, Model model,
			BbsVO vo) throws Exception {

		logger.info(upfile.getName());
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
			vo.setFilename(UUName);
			service.create(vo.setIsfile("T"));
			model.addAttribute("vo", service.read(vo.getBbsNo()));

		}

		return "redirect:/bbs/board";

	}

	@RequestMapping(value = "/singleDown", method = RequestMethod.GET)
	public void singleDown(BbsVO vo, Model model, HttpServletResponse response) throws IOException {

		// 선택한 글번호로 그 글에 업로드된 파일의 이름 가져오기
		String UUFileName = service.getFileName(vo);
		
		// 다운로드 알림창이 뜨도록 하기 위해서 컨텐트 타입을 8비트 바이너리로 설정한다.
		response.setContentType("application/octet-stream");

		// 저장될 파일 이름을 설정한다.
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String(vo.getFilename().getBytes("UTF-8"), "8859_1"));
		/*response.setHeader("Content-Disposition", "attachment; filename=\""
				+ java.net.URLEncoder.encode(vo.getFilename(), "UTF-8") + "\";");*/

		File file = new File("C:\\zzz\\upload\\" + UUFileName);

		FileInputStream fis = new FileInputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(
				response.getOutputStream());

		byte[] buffer = new byte[1024 * 8];

		while (true) {
			int cnt = fis.read(buffer);
			if (cnt == -1) {
				break;
			}
			bos.write(buffer, 0, cnt);
		}

		bos.close();
		fis.close();
		
	}

	/*@Override
	public String getContentType() {
		return "application/octet-stream";
		// application인데 stream을 통해서 보내긴 하겠지만 뭔지 모르겟다.따라서 이걸 부르면 다운로드 받게 해준다.
	}

	@Override
	@RequestMapping(value = "/singleDown", method = RequestMethod.GET)
	protected void renderMergedOutputModel(BbsVO vo,
			HttpServletRequest reqeust, HttpServletResponse response) throws Exception {
		// map은 우리가 modelAndView로 넘기는 값이 들어온다.
		// map : fileName 키값으로 다운로드 시킬 파일 명을 받는다.
		ServletContext ctx = getServletContext();
		// webapplication 경로-> filesystem결로로 바꿔준다.
		String realPath = ctx.getRealPath("/upload");// /upload : web
														// application Root경로
														// //파일경오만 바뀌지 다른 것은 그대로
														// 가져다가 재사용가능하다.

		String fileName = (String) map.get("fileName");
		File downFile = new File(realPath, fileName);
		// 응답처리
		// 1. contentType처리
		response.setContentType(getContentType());
		// 2. 다운 로드할 파일 명을 header정보로 설정
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String(fileName.getBytes("UTF-8"), "8859_1"));// 8859-1방식은
																	// 라틴방식이다.
																	// (한글처리)
		// 위에서 filename으로 파일이 넘어간다.
		OutputStream os = response.getOutputStream();
		FileInputStream fi = new FileInputStream(downFile);
		
		// fi.read()한것을 os.write한 효과가 난다. 클라이언트에게 파일이 날아간다.
		FileCopyUtils.copy(fi, os);

	}*/
}
