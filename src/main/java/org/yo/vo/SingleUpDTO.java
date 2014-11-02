package org.yo.vo;

import org.springframework.web.multipart.MultipartFile;

public class SingleUpDTO {
	private String comment;
	private MultipartFile upfile;// 업로드된 파일 정보를 저장할 변수

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}

}