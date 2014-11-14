package org.yo.web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.yo.service.BoardService;
import org.yo.vo.BbsVO;

@Controller
@RequestMapping("/bbs/file/*")
public class FileController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileController.class);

	private final static String UPLOAD_DIR = "C:\\zzz\\upload\\";
	

	@Inject
	BoardService service;

	@RequestMapping(value = "/view", produces = "image/jpeg")
	public @ResponseBody byte[] viewFile(String path, HttpServletResponse res) throws Exception {

		logger.info(path);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		InputStream fin = new FileInputStream(UPLOAD_DIR + path);

		FileCopyUtils.copy(fin, bos);

		return bos.toByteArray();
	}

	private String createThumbnail(File origin) throws Exception {

		BufferedImage originalImage = ImageIO.read(origin);
		BufferedImage thumbnailImage = new BufferedImage(
				originalImage.getWidth() / 2, originalImage.getHeight() / 2,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D g = thumbnailImage.createGraphics();
		g.drawImage(originalImage, 0, 0, thumbnailImage.getWidth(),
				thumbnailImage.getHeight(), null);

		File outputFile = new File(UPLOAD_DIR + "s_" + origin.getName());

		ImageIO.write(thumbnailImage, "jpg", outputFile);
		
		return "s_" + origin.getName();
	}

	@RequestMapping(value="/upload", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String uploadFile(MultipartFile file, HttpServletResponse res) throws Exception {

		if (file.isEmpty()) {
			return "NONE";
		}

		String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

		String suffix = fileName.substring(fileName.lastIndexOf("."));

		logger.info("SUFFIX :" + suffix);

		InputStream in = file.getInputStream();

		File uploadedFile = new File(UPLOAD_DIR + fileName);

		OutputStream fos = new FileOutputStream(uploadedFile);

		FileCopyUtils.copy(in, fos);

		logger.info("-------------------");

		logger.info(fileName);
		logger.info("-------------------");

		boolean isImage = isImage(fileName, suffix);
		if (isImage) {
			fileName = createThumbnail(uploadedFile);
		}
		

		String jsObjStr = "{fileName:'" + fileName + "',isImage:" + isImage
				+ ", suffix:'" + suffix + "'}";

		String str = "<script>parent.updateResult(" + jsObjStr + ");</script>";

		return str;

	}

	private boolean isImage(String fileName, String suffix) {

		if (suffix.contains(".jpg") || suffix.contains(".png") || suffix.contains("gif") || suffix.contains("bmp")) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void singleDown(BbsVO vo, Model model, HttpServletResponse response)
			throws IOException {

		System.out.println(vo.toString());
		
		String downFileName = vo.getFilename();
		
		String suffix = vo.getSuffix();
		
		boolean isimage = isImage(downFileName, suffix);
		if(isimage){
			downFileName = downFileName.substring(2);
		}


		System.out.println("다운 : " + downFileName);

		File downFile = new File(UPLOAD_DIR + downFileName);

		// 응답처리
		// 1. contentType처리
		response.setContentType("application/octet-stream");

		// 2. 다운 로드할 파일 명을 header정보로 설정
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String(downFileName.getBytes("UTF-8"), "8859_1"));// 8859-1방식은
																			// 라틴방식이다.
																			// (한글처리)

		// 위에서 filename으로 파일이 넘어간다.
		OutputStream os = response.getOutputStream();
		FileInputStream fi = new FileInputStream(downFile);

		// fi.read()한것을 os.write한 효과가 난다. 클라이언트에게 파일이 날아간다.
		FileCopyUtils.copy(fi, os);

	}

}
